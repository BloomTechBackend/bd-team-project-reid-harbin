import NotificationsPage from "./notificationsPage";
import React from "react";
import { FaCalendar, FaBell } from 'react-icons/fa';
import EventViewAndCreate from "./eventViewAndCreate";



  const UserPanel = () => {
    const [Page, setPage] = React.useState(<NotificationsPage/>);
    const NavBarButton = ({ icon, type, page }) => (
        <button onClick= {() => setPage(page)} className="flex text-white drop-shadow-md rounded-xl items-center h-20 w-16 mb-2 pl-3  bg-slate-700
         hover:bg-slate-700 hover:text-secondary group-hover:w-52 overflow-hidden hover:mr-2 group-hover:ease-in-out duration-300">
                            <div>{icon}</div>
                            <div className="invisible group-hover:visible p-2 text-center text-lg font-extrabold">{type}</div>
        </button>
    );

    return (
        <div className="flex">
            <div className="navbox group text-center text-md text-clip  shadow-primary h-screen text-slate-700
             transition-all duration-300 w-16 p-2 hover:w-52 bg-white dark:bg-secondary mt-2">
                <NavBarButton page={<EventViewAndCreate/>} icon={<FaCalendar size="36" />} type={"EVENTS"}/>
                <NavBarButton page={<NotificationsPage/>} icon={<FaBell size="36" />}type={"NOTIFICATIONS"}/>
            </div>
            {Page}
        </div>
    );

  }

  export default UserPanel;