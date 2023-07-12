import React from "react";
import CreateEventPage from "./createEventPage";
import EventsPage from "./eventsPage";

const EventViewAndCreate = () => {
    const [isCreate, setIsCreate] = React.useState(false);
    const [page, setPage] = React.useState(<EventsPage/>);

    const swithPages = () => {
        setIsCreate(!isCreate);
        if (!isCreate) {
            setPage(<CreateEventPage/>);
        } else {
            setPage(<EventsPage/>);
        }
    }

    return (
        <div className="text-white mt-4 ml-5 w-full rounded-tl-lg bg-slate-700">
            {isCreate ? 
            (<div>
                {page}
                <div className="px-4">
                    <button onClick={() => swithPages(<EventsPage/>)} className=" text-2xl font-bold text-white bg-secondary rounded-lg group p-2 w-full">Cancel</button>
                </div> 
            </div>)
            : 
            (<div>
                <div className="pt-4 px-4">
                    <button onClick={() => swithPages(<CreateEventPage/>)} className="text-2xl font-bold text-white bg-secondary rounded-lg group p-2 w-full">Create an Event</button>
                </div> 
                {page}
            </div>)}
        </div>
    )
}

export default EventViewAndCreate;