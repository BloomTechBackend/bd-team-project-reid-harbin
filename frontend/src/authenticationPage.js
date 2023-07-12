import React from "react"
import axios from "axios";
import UserPanel from "./userPanel";
import { headers } from "./App";
import { FaSpinner } from 'react-icons/fa';
export let MemberId;
export let FamilyId;

const AuthenticationPage = () => {
    const [memberName, setMemberName] = React.useState('');
    const [memberPassword, setMemberPassword] = React.useState('');
    const [MemberSuccess, setMemberSuccess] = React.useState(false);
    
    const [familyName, setFamilyName] = React.useState('');
    const [familyPassword, setFamilyPassword] = React.useState('');
    
    const [hasFamily, setHasFamily] = React.useState(false);
    
    const [isSignIn, setIsSignIn] = React.useState(true);
    const [isJoin, setIsJoin] = React.useState(true);
    const [isLoading, setIsLoading] = React.useState(false);
    
    const handleSignIn = async (evt) => {
        setIsLoading(true);
        evt.preventDefault();
        
        const res = await axios.get("https://49042ah3j2.execute-api.us-west-2.amazonaws.com/beta/member?memberName="+ memberName +
        "&memberPassword=" + memberPassword, headers);
        console.log("SIGNED IN");
        if (res.data.memberId != null) {
            console.log(res.data);
            MemberId = res.data.memberId;
            if (res.data.memberFamilyId != null) {
                setHasFamily(true);
                FamilyId = res.data.memberFamilyId;
            }
            setMemberSuccess(true);
            setIsLoading(false);
        } else {
            setIsLoading(false);
            alert(res.data.error);
            console.log(res.data.error);
        }
    }

    const handleSignUp = async (evt) => {
        setIsLoading(true);
        evt.preventDefault();
        const res = await axios.post("https://49042ah3j2.execute-api.us-west-2.amazonaws.com/beta/member?name="+ memberName +
        "&password=" + memberPassword, headers);
        console.log("SIGNED UP");
        if (res.data.errorMessage == null) {
            MemberId = res.data.member.memberId;
            setMemberSuccess(true);
            setIsLoading(false);
        } else {
            console.log(res.data);
            setIsLoading(false)
            alert(res.data.errorMessage);
        }   
    }
    
    const handleCreate = async (evt) => {
        setIsLoading(true);
        evt.preventDefault();
        
        const res = await axios.post("https://49042ah3j2.execute-api.us-west-2.amazonaws.com/beta/family?familyName="+ familyName +
        "&familyPassword=" + familyPassword + "&familyCreatorId=" + MemberId, headers);
        console.log("Created Family");
        if (res.data.errorMessage == null) {
            console.log(res.data);
            FamilyId = res.data.familyModel.familyId;
            console.log(FamilyId);
            setHasFamily(true);
            setIsLoading(false);
        } else {
            setIsLoading(false);
            alert(res.data.errorMessage)
            console.log(res.data.error);
        }
    }
    
    const handleJoin = async (evt) => {
        setIsLoading(true);
        evt.preventDefault();
        console.log("Family Password: " + familyPassword + " familyName: " + familyName);
        const res = await axios.put("https://49042ah3j2.execute-api.us-west-2.amazonaws.com/beta/family?familyName="+ familyName +
        "&familyPassword=" + familyPassword + "&memberId=" + MemberId, headers);
        console.log("Joined Family");
        if (res.data.errorMessage == null) {
            FamilyId = res.data.familyModel.familyId;
            setHasFamily(true);
            setIsLoading(false);
        } else {
            setIsLoading(false);
            console.log(res.data);
            alert(res.data.errorMessage);
        }   
    }


    if (isLoading) {
        return (
            <div className="flex justify-center place-items-center h-screen">
                <div className=" flex text-lg w-1/2 h-3/4 text-white justify-center items-center bg-slate-700 rounded-lg">
                    <FaSpinner size="100" className="animate-spin"/>
                </div>
            </div>
        )
    }
   
    if (MemberSuccess) {
            if (hasFamily) {
                return <UserPanel/>
            } else if (isJoin) {
                return (
                    <div className="flex justify-center place-items-center h-screen">
                        <div className=" flex text-lg w-1/2 h-3/4 text-white justify-center items-center rounded-lg">
                            <form className="text-lg py-40 px-36 text-white justify-end bg-slate-700">
                                <h1 className="text-4xl relative bottom-16 left-20">Join an Existing Family</h1>
                                <label>Family Name</label>
                                <div className="pt-2 pb-4">
                                    <input className="text-3xl p-2 bg-slate-600 outline outline-secondary rounded-lg"
                                        type="text"
                                        required
                                        value={familyName}
                                        onChange={(e) => setFamilyName(e.target.value)}
                                    />
                                </div>
                                <label>Family Password</label>
                                <div className="pt-2 pb-2">
                                    <input className=" text-3xl p-2 bg-slate-600 outline outline-secondary rounded-lg"
                                        type="text"
                                        required
                                        value={familyPassword}
                                        onChange={(e) => setFamilyPassword(e.target.value)}
                                        />
                                </div>
                                <div className="text-xs">*Password must contain no spaces, a number, lowercase letter and an uppercase letter*</div>
                                <button onClick={handleJoin} className="flex justify-center font-bold text-white text-lg drop-shadow-md rounded-xl items-center h-20 w-96 mt-4  bg-slate-600
                                    hover:bg-secondary hover:text-slate-700 overflow-hidden">
                                    Join
                                </button>
                                <button onClick={() => setIsJoin(false)} className="pt-4 hover:text-secondary hover:underline hover:decoration-solid hover:decoration-secondary">Need to Create a Family?</button>
                            </form>
                        </div>
                    </div>
                )
            } else {
                return (
                    <div className="flex justify-center place-items-center h-screen">
                        <div className=" flex text-lg w-1/2 h-3/4 text-white justify-center items-center rounded-lg">
                            <form className="text-lg py-40 px-36 text-white justify-end bg-slate-700 rounded-lg">
                                <h1 className="text-4xl relative bottom-16 left-20">Create a New Family</h1>
                                <label>Family Name</label>
                                <div className="pt-2 pb-4">
                                    <input className="text-3xl p-2 bg-slate-600 outline outline-secondary rounded-lg"
                                        type="text"
                                        required
                                        value={familyName}
                                        onChange={(e) => setFamilyName(e.target.value)}
                                    />
                                </div>
                                <label>Family Password</label>
                                <div className="pt-2 pb-2">
                                    <input className=" text-3xl p-2 bg-slate-600 outline outline-secondary rounded-lg"
                                        type="text"
                                        required
                                        value={familyPassword}
                                        onChange={(e) => setFamilyPassword(e.target.value)}
                                        />
                                </div>
                                <div className="text-xs">*Password must contain no spaces, a number, lowercase letter and an uppercase letter*</div>
                                <button onClick={handleCreate} className="flex justify-center font-bold text-white text-lg drop-shadow-md rounded-xl items-center h-20 w-96 mt-4  bg-slate-600
                                    hover:bg-secondary hover:text-slate-700 overflow-hidden">
                                    Create
                                </button>
                                <button onClick={() => setIsJoin(true)} className="pt-4 hover:text-secondary hover:underline hover:decoration-solid hover:decoration-secondary">Need to Join a Family?</button>
                            </form>
                        </div>
                    </div>    
                )
            }
    } else if (isSignIn) {
        return (
            <div className="flex justify-center items-center h-screen">
                <div className=" flex text-lg w-1/2 h-3/4 text-white justify-center items-center rounded-lg">
                    <form className="text-lg py-40 px-36 text-white justify-end bg-slate-700 rounded-lg">
                        <h1 className="text-4xl relative bottom-16 left-20">Welcome Back!</h1>
                        <label>Username</label>
                        <div className="pt-2 pb-4">
                            <input className="text-3xl p-2 bg-slate-600 outline outline-secondary rounded-lg"
                                type="text"
                                required
                                value={memberName}
                                onChange={(e) => setMemberName(e.target.value)}
                            />
                        </div>
                        <label>Password</label>
                        <div className="pt-2 pb-2">
                            <input className=" text-3xl p-2 bg-slate-600 outline outline-secondary rounded-lg"
                                type="text"
                                required
                                value={memberPassword}
                                onChange={(e) => setMemberPassword(e.target.value)}
                                />
                        </div>
                        <div className="text-xs">*Password must contain no spaces, a number, lowercase letter and an uppercase letter*</div>
                        <button onClick={handleSignIn} className="flex justify-center font-bold text-white text-lg drop-shadow-md rounded-xl items-center h-20 w-96 mt-4  bg-slate-600
                            hover:bg-secondary hover:text-slate-700 overflow-hidden">
                            Sign In
                        </button>
                        <button onClick={() => setIsSignIn(false)} className="pt-4 hover:text-secondary hover:underline hover:decoration-solid hover:decoration-secondary">Don't have an account?</button>
                    </form>
                </div>
            </div>
        )
    } else {
        return (
            <div className="flex justify-center place-items-center h-screen">
                <div className=" flex text-lg w-1/2 h-3/4 text-white justify-center items-center">
                    <form className="text-lg py-40 px-36 text-white justify-end bg-slate-700 rounded-lg">
                        <h1 className="text-4xl relative bottom-16 left-20">Create an Account</h1>
                        <label>Username</label>
                        <div className="pt-2 pb-4">
                            <input className="text-3xl p-2 bg-slate-600 outline outline-secondary rounded-lg"
                                type="text"
                                required
                                value={memberName}
                                onChange={(e) => setMemberName(e.target.value)}
                            />
                        </div>
                        <label>Password</label>
                        <div className="pt-2 pb-2">
                            <input className=" text-3xl p-2 bg-slate-600 outline outline-secondary rounded-lg"
                                type="text"
                                required
                                value={memberPassword}
                                onChange={(e) => setMemberPassword(e.target.value)}
                                />
                        </div>
                        <div className="text-xs">*Password must contain no spaces, a number, lowercase letter and an uppercase letter*</div>
                        <button onClick={handleSignUp} className="flex justify-center font-bold text-white text-lg drop-shadow-md rounded-xl items-center h-20 w-96 mt-4  bg-slate-600
                            hover:bg-secondary hover:text-slate-700 overflow-hidden">
                            Sign Up
                        </button>
                        <button onClick={() => setIsSignIn(true)} className="pt-4 hover:text-secondary hover:underline hover:decoration-solid hover:decoration-secondary">Already have an account?</button>
                    </form>
                </div>
            </div>    
        )
    } 
}



export default AuthenticationPage;