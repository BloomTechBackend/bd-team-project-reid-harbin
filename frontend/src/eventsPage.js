import axios from "axios";
import React from "react";
import { FamilyId, MemberId } from "./authenticationPage";
import { FaSpinner } from 'react-icons/fa';
import { headers } from "./App";



const EventsPage = () => {
    const [events, setEvents] = React.useState([]);
    const [isLoading, setIsLoading] = React.useState(true);
    React.useEffect(() => { 
        fetchEvents();
    }, []);

    const fetchEvents = async (evt) => {
        setIsLoading(true);

        try {
            const res = await axios.get("https://49042ah3j2.execute-api.us-west-2.amazonaws.com/beta/family/" + FamilyId +
            "/events", headers);
            console.log(res.data);
            setEvents(res.data.familyEvents);
            setIsLoading(false);
        } catch (error) {
            console.log(error);
        }
    };

    const handleJoinEvent = async (eventToJoin) => {
        console.log("Joining: " + eventToJoin.e.eventId);

        try { 
            const res = await axios.put("https://49042ah3j2.execute-api.us-west-2.amazonaws.com/beta/family/" + FamilyId +
            "/events?memberId=" + MemberId + "&eventId=" + eventToJoin.e.eventId, headers);
            res.data.error ? console.log(res.data.error) : 
            fetchEvents();
            setIsLoading(false);
        } catch (error) {
            console.log(error);
        }
    }

    const renderAttendingMemberNames = (e) => {
        if (e.eventAttendingMemberNames != null) {
            return (
                e.eventAttendingMemberNames.map((name) => (<li key={name} className=" pb-4 pt-2 pr-2">{name}</li>))
            )
        }
    }
    
    return (
        <div>
            {isLoading ? 
            (<div className="flex justify-center items-center text-white mt-48">
                <FaSpinner size="100" className="animate-spin"/>
            </div>) :            
            (<div>
                <ul className="font-semibold text-2xl mt-4 text-white"> 
                    {events.length > 0 ? events.map((e) => (
                        <li key={e.eventId} className="overflow-hidden rounded-lg m-4 p-2 bg-slate-600 shadow-xl 
                        ease-in-out duration-300 flex">
                            <div className="group h-24 w-full hover:h-52 hover:pb-16 ease-in-out duration-300 transition-all delay-75">
                                <h1 className="border-b-2 py-2 text-secondary border-secondary font-bold">
                                    {e.eventType} | {e.eventDate} | {e.eventStartTime} - {e.eventEndTime}
                                </h1>
                                <ul className="flex bg-slate-600 rounded-lg text-md font-normal">
                                    {renderAttendingMemberNames(e)}
                                </ul>
                                <p className="bg-slate-700 rounded-lg p-2 font-normal
                                    group-hover:visible group-hover:delay-300">
                                    {e.eventDescription}
                                </p>
                                <button onClick={() => handleJoinEvent({e})} className="text-slate-700 active:bg-slate-600 
                                    active:text-secondary text-center mt-2 text-xl w-36 h-fit bg-secondary rounded-lg 
                                    shadow-sm p-1">
                                    Join
                                </button>
                            </div>
                        </li>)) : 
                        (<div className="flex h-full justify-center items-center">
                            No Upcoming Events.
                        </div>)}
                </ul>
            </div>)}
        </div>
    )
}

export default EventsPage;
