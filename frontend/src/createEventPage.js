import axios from "axios";
import React from "react";
import { headers } from "./App";
import { FamilyId, MemberId } from "./authenticationPage";
import { FaSpinner } from "react-icons/fa";


const CreateEventPage = () => {
    const [eventType, setEventType] = React.useState("");
    const [eventDate, setEventDate] = React.useState("");
    const [eventStartTime, setEventStartTime] = React.useState("");
    const [eventEndTime, setEventEndTime] = React.useState("");
    const [eventDescription, setEventDescription] = React.useState("");
    const [eventAttendingMembers, setEventAttendingMembers] = React.useState([]);
    const [allFamilyMembersNames, setAllFamilyMembersNames] = React.useState([]);
    const [isLoading, setIsLoading] = React.useState(true);
    const [isCreating, setIsCreating] = React.useState(false);

    React.useEffect(() => { 
        fetchFamilyMembersNames();
    }, []);

    const fetchFamilyMembersNames = async (evt) => {
        try {
            console.log("FETCHING NAMES");
            const res = await axios.get("https://49042ah3j2.execute-api.us-west-2.amazonaws.com/beta/family/" + FamilyId, headers);
            setAllFamilyMembersNames(res.data.family.familyMemberNames);
            console.log(res.data)
            setIsLoading(false);
        } catch (error) {
            console.log(error);
            setIsLoading(false);
        }
    };

    const EventTypeButton = ({ eventName }) => {
        
        const buttonStyle = (eventName == eventType) ? "text-slate-700 text-center my-4 p-2 text-xl w-36 h-fit bg-secondary rounded-lg shadow-sm" :
                                                       "text-white text-center my-4 p-2 text-xl w-36 h-fit bg-slate-600 rounded-lg shadow-sm";
        return (
            <button className={buttonStyle} onClick={() => setEventType(eventName)}>
                    {eventName}
            </button>
        );
    }

    const handleClickName = (name) => {

        setEventAttendingMembers((prevMembers) => {
          if (prevMembers.includes(name)) {
            return prevMembers.filter((member) => member !== name);
          } else {
            return [...prevMembers, name];
          }
        });
      };
      
      const renderFamilyNames = () => {
        if (allFamilyMembersNames != null) {
          return allFamilyMembersNames.map((name) => {
            const isAttending = eventAttendingMembers != null && eventAttendingMembers.includes(name);
            const buttonStyle = isAttending ? "text-white text-center my-4 mr-4 p-2 text-xl w-36 h-fit bg-secondary rounded-lg shadow-sm" : 
                                              "text-white text-center my-4 mr-4 p-2 text-xl w-36 h-fit bg-slate-600 rounded-lg shadow-sm";
            
            return (
              <div key={name}>
                <button className={buttonStyle} onClick={() => handleClickName(name)}>
                  {name}
                </button>
              </div>
            );
          });
        }
      };

    const handleCreateEvent = async (evt) => {
        evt.preventDefault();
        setIsCreating(true);
        let eventStartMeridian;
        let eventEndMeridian;
        
        let startHour = parseInt(eventStartTime.substring(0, 2));
        let endHour = parseInt(eventEndTime.substring(0, 2));
        
        
        console.log("TEST LOG: " + startHour);

        let currStartTime = eventStartTime;
        let currEndTime = eventEndTime;

        if (startHour < 12) {
            eventStartMeridian = "AM";
            if (startHour === 0) {
                currStartTime = "12" + currStartTime.substring(2);
            }
        } else if (startHour === 12) {
            eventStartMeridian = "PM";
        } else {
            startHour -= 12;
            eventStartMeridian = "PM";
            currStartTime = startHour + currStartTime.substring(2);
        }
        
        if (endHour < 12) {
            eventEndMeridian = "AM";
            if (endHour === 0) {
                currEndTime = "12" + currEndTime.substring(2);
            }
        } else if (endHour === 12) {
            eventEndMeridian = "PM";
        } else {
            endHour -= 12;
            eventEndMeridian = "PM";
            currEndTime = endHour + currEndTime.substring(2);
        }
        const request = {
            "eventDate": eventDate,
            "eventOwnerName": MemberId,
            "eventType": eventType,
            "eventStartTime": currStartTime,
            "eventEndTime": currEndTime,
            "eventStartMeridian": eventStartMeridian,
            "eventEndMeridian": eventEndMeridian,
            "eventDescription": eventDescription,
            "eventAttendingMembers": eventAttendingMembers
        }

        try {
            const res = await axios.post("https://49042ah3j2.execute-api.us-west-2.amazonaws.com/beta/family/" + FamilyId +
                "/events", request, headers);
            res.data.error ? console.log(res.data.error) : console.log(res.data);
            setIsCreating(false);
        } catch(e) {
            console.log(e);
        }
        console.log(request);
        
    }
    return (
        <div>
            {isCreating ? 
            
            (<div className="flex h-full justify-center items-center">
                <FaSpinner className="animate-spin text-white" size="80"/>
                </div>) : 
            (<div>
                <div className="flex justify-between mx-4 in-w-fit font-bold">
                    <EventTypeButton eventName={"Breakfast"}/>
                    <EventTypeButton eventName={"Lunch"}/>
                    <EventTypeButton eventName={"Dinner"}/>
                    <EventTypeButton eventName={"Work"}/>
                    <EventTypeButton eventName={"School"}/>
                    <EventTypeButton eventName={"Extracuricular"}/>
                    <EventTypeButton eventName={"Doctor"}/>
                    <EventTypeButton eventName={"Special"}/>
                </div>
                <div className="grid-row-3  text-white text-3xl font-bold">
                    <div className="m-4">
                        <input className="p-2 bg-slate-600 rounded-lg mb-4 focus:outline-secondary focus:outline-none"
                                            type="date"
                                            required
                                            value={eventDate}
                                            onChange={(e) => setEventDate(e.target.value)}
                                            />
                        <input className="ml-4 p-2 bg-slate-600 rounded-lg mb-4 w-52 focus:outline-secondary focus:outline-none"
                                            type="time"
                                            required
                                            onChange={(e) => {setEventStartTime(e.target.value)}}
                                            />
                        <label className="m-2"> to </label>
                        <input className="p-2 bg-slate-600 rounded-lg mb-4 w-52 focus:outline-secondary focus:outline-none 
                                        focus:bg-slate-600"
                                        type="time"
                                            required
                                            onChange={(e) => {setEventEndTime(e.target.value)}}
                                        />
                    </div>
                    <textarea className="p-2 mx-4 bg-slate-600 rounded-lg mb-4 w-9/12 focus:outline-secondary focus:outline-none 
                                        resize-none"
                                        required
                                        placeholder="Description of your event"
                                        rows="2"
                                        onChange={(e) => setEventDescription(e.target.value)}
                                        />
                </div>
                <div className="px-4 text-white text-3xl font-bold">
                    <div className="flex">
                        {isLoading ? (<div className="flex w-full h-20 bg-slate-600 rounded-lg justify-center items-center">
                                        <FaSpinner className="animate-spin" size="40"/> </div>) : (renderFamilyNames())}
                    </div>    
                    <button className="w-fit px-4 py-2  font-bold my-4 bg-secondary rounded-lg mb-4 active:bg-slate-600 active:text-secondary overflow-hidden" 
                        onClick={handleCreateEvent}>
                        Create Event
                    </button>
                </div>
            </div>)}
        </div>
    );
}   
export default CreateEventPage;