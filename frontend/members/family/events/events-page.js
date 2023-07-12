const urlParams = new URLSearchParams(window.location.search);
const memberId = urlParams.get('memberId');
const familyId = urlParams.get('familyId');

let headers = { authorization: {
        'x-api-key': 'ROhDefLTvE9WkWAYyBULD86cNpB2HWKL4fTJL3WX'
    }
}
const toolBarDiv = document.querySelector(".tool-bar");
const loadingDiv = document.querySelector(".loading");
const eventsPageDiv = document.querySelector(".events-page");
window.onload = async function(evt) {
    loadingDiv.style.display = "block";
    toolBarDiv.style.display = "none";
    eventsPageDiv.style.display = "none";
    axios.get("https://49042ah3j2.execute-api.us-west-2.amazonaws.com/beta/"+memberId+"/family/"+familyId+"/events")
        .then((res) => {
            if (res.data.errorMessage != null) {
                alert(res.data.errorMessage);
                location.reload();
            } else {
                console.log(res.data);

                let familyEvents = res.data.familyEvents;
                const eventsDiv = document.querySelector(".events");

                for (let i = 0; i < familyEvents.length; i++) {
                    let h1 = document.createElement("h1");
                    let event = familyEvents[i];
                    let startMinutes;
                    let endMinutes;
                    let startHour;
                    let endHour;
                    if (event.eventStartTime.minute < 10) {
                        startMinutes = "0" + event.eventStartTime.minute;
                    } else {
                        startMinutes = event.eventStartTime.minute;
                    }

                    if (event.eventEndTime.minute < 10) {
                        endMinutes = "0" + event.eventEndTime.minute;
                    } else {
                        endMinutes = event.eventEndTime.minute;
                    }

                    if (event.eventStartTime.hour > 12) {
                        startHour = event.eventStartTime.hour - 12;
                    } else {
                        startHour = event.eventStartTime.hour;
                    }

                    if (event.eventEndTime.hour > 12) {
                        endHour = event.eventEndTime.hour - 12;
                    } else {
                        endHour = event.eventEndTime.hour;
                    }

                    if (startHour == 0) {
                        startHour = 12;
                    }

                    if (endHour == 0) {
                        endHour = 12;
                    }

                    let date = event.eventDate.monthValue + "/" + event.eventDate.dayOfMonth;
                    let startTime = startHour + ":" +
                        startMinutes + " " +
                        event.eventStartMeridian;
                    let endTime = endHour + ":" +
                        endMinutes + " " +
                        event.eventEndMeridian;

                    h1.innerText = familyEvents[i].eventType + " | " +
                                    date + " | " +
                                    startTime + " - " + endTime;
                    let p = document.createElement("p");
                    p.innerText = event.eventDescription;

                    eventsDiv.append(h1);
                    h1.append(p);
                }
            }
            loadingDiv.style.display = "none";
            toolBarDiv.style.display = "block";
            eventsPageDiv.style.display = "block";
        })
}


function loadCreateEvents() {
    location.href = "https://touchbase-api.s3.us-west-2.amazonaws.com/members/events/create/create-event.html?memberId="
        +memberId+"&familyId="+familyId;
}

function loadNotifications() {
    location.href = "http://touchbase-api.s3-website-us-west-2.amazonaws.com/members/notifications" +
                        "/notifications-page.html?memberId=" + memberId;
}

function loadEvents() {
    location.href = "http://touchbase-api.s3-website-us-west-2.amazonaws.com" +
        "/members/events/events-page.html?memberId="+memberId+"&familyId="+familyId;
}

function loadFamily() {
    location.href = "http://touchbase-api.s3-website-us-west-2.amazonaws.com/members/family/family-page.html?"
        +"memberId="+memberId+"&familyId="+familyId;
}

function loadAccount() {
    location.href = "https://touchbase-api.s3.us-west-2.amazonaws.com/members/member-page.html?memberId="+memberId;
}