import axios from "axios";
import React from "react";
import { MemberId } from "./authenticationPage";
import { FaTrash, FaSpinner } from 'react-icons/fa';
import { headers } from "./App";

const NotificationsPage = () => {
    const [notifs, setNotifs] = React.useState([]);
    const [isLoading, setIsLoading] = React.useState(true);
    React.useEffect(() => { 
        fetchNotifications();
    }, []);
    
    const fetchNotifications = async (evt) => {
        try {
            const res = await axios.get("https://49042ah3j2.execute-api.us-west-2.amazonaws.com/beta/member/" + MemberId +
            "/notifications", headers);
            setNotifs(res.data.notifications);
            setIsLoading(false);
        } catch (error) {
            console.log(error);
        }
    };

    const removeNotification = async (index) => {
        try {
            const res = await axios.put("https://49042ah3j2.execute-api.us-west-2.amazonaws.com/beta/member/" + MemberId +
            "/notifications?memberNotificationIndex=" + index, headers);
            setNotifs(res.data.notifications);
        } catch (error) {
            console.log(error);
        }   
    };


    return (
        <div className="flex text-white mt-4 ml-5 w-full rounded-tl-lg bg-slate-700">{isLoading ? (<div className="flex w-full justify-center items-center text-white"><FaSpinner size="100" className="animate-spin"/></div>) :
        (<div className="flex mt-4 ml-5 w-full rounded-tl-lg bg-slate-700">
            <ul className=" font-semibold text-2xl mx-4 mt-4 text-white w-full">
                {notifs.length > 0 ?  notifs.map((n,index) => (
                    <li key={index} className="group rounded-lg m-4 px-2 py-2 bg-slate-600 shadow-xl backdrop-blur-lg
                    ease-in-out duration-300">
                        <div className="bg-slate-600 group-hover:ml-16 group-hover:ease-in-out duration-300 flex">
                            <div>
                                <h1>
                                    {n.notificationHeadline} | From: {n.notificationSenderName} | {n.notificationDate}
                                </h1>
                                <p>
                                    {n.notificationDescription}
                                </p>
                            </div>
                            
                            <button onClick = {() => removeNotification(index)}
                                className="absolute items-center text-secondary py-2 px-2 delay-0  invisible group-hover:delay-200 group-hover:visible group-hover:left-2">
                                    <FaTrash size="40"/>
                            </button>
                        </div>
                    </li>
                )) : <div className="flex h-full justify-center items-center">No New Notifications</div>}
            </ul>
        </div>)
            }</div>
    )
};

export default NotificationsPage;