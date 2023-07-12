const urlParams = new URLSearchParams(window.location.search);
const memberId = urlParams.get('memberId');
const familyId = urlParams.get('familyId');

let eventType;
const eventTypes = ["Breakfast", "Lunch", "Dinner", "Work", "School", "Extracurricular", "Misc"];

let startMeridian;
let endMeridian;


let headers = { authorization: {
        'x-api-key': 'ROhDefLTvE9WkWAYyBULD86cNpB2HWKL4fTJL3WX'
    }
}

let textarea = document.querySelector("textarea");
    textarea.focus();
    textarea.setSelectionRange(0, 0);

const toolBarDiv = document.querySelector(".tool-bar");
const loadingDiv = document.querySelector(".loading");
const createEventPageDiv = document.querySelector(".create-event-page");

window.onload = async function(evt) {
    loadingDiv.style.display = "none";
    toolBarDiv.style.display = "block";
    createEventPageDiv.style.display = "block";
}




let submitButton = document.querySelector("#create-event-button");
submitButton.onclick = async function(evt) {
    evt.preventDefault();

    loadingDiv.style.display = "block";
    toolBarDiv.style.display = "none";
    createEventPageDiv.style.display = "none";

    const reloadMemberId = memberId;
    const reloadFamilyId = familyId;

    document.querySelector("#description-form").submit();
    document.querySelector("#date-time-form").submit();

    let eventDescription = document.querySelector("#event-description-box").value;
    let eventMonth = document.querySelector("#month").value;
    let eventDay = document.querySelector("#day").value;
    let startTime = document.querySelector("#start-time").value;
    let endTime = document.querySelector("#end-time").value;

    if (eventMonth < 10) {
        eventMonth = "0" + eventMonth;
    }

    if (eventDay < 10) {
        eventDay = "0" + eventDay;
    }

    axios.post("https://49042ah3j2.execute-api.us-west-2.amazonaws.com/beta/"+memberId+"/family/"+familyId+"/events", {
        "familyId": familyId,
        "eventOwnerId": memberId,
        "eventType": eventType,
        "eventDate": eventMonth + " " + eventDay + " 2023",
        "eventStartMeridian": startMeridian,
        "eventEndMeridian": endMeridian,
        "eventStartTime": startTime + " " + startMeridian,
        "eventEndTime": endTime + " " + endMeridian,
        "description": eventDescription
    }, headers).then((res) => {
        if (res.data.errorMessage != null) {
            alert(res.data.errorMessage);
        }
    });

    location.href = "https://touchbase-api.s3.us-west-2.amazonaws.com/members/events/events-page.html?memberId="+
        memberId+"&familyId="+familyId;
}

function setType(type) {
    eventType = eventTypes[type - 1];
    for (let i = 1; i <= 7; i++) {
        let button = document.querySelector( "#button" + i);
        if (i != type) {
            button.style.backgroundColor = "white";
        } else {
            button.style.background = "#33ACFF";
        }
    }
}

function highlightBox() {
    let textarea = document.querySelector("#event-description-box");
    textarea.style.outlineColor = "#33ACFF";
}

function highlightMonthBox() {
    let monthBox = document.querySelector("#month");
    monthBox.style.outlineColor = "#33ACFF";
}

function highlightDayBox() {
    let dayBox = document.querySelector("#day");
    dayBox.style.outlineColor = "#33ACFF";
}

function checkMonthNum() {
    let monthNum = document.querySelector("#month");
    let dayNum = document.querySelector("#day");
    dayNum.value = null;

    if (monthNum.value > 12) {
        monthNum.value = 12;
    }

    if (monthNum.value < 1) {
        monthNum.value = null;
    }
}

function checkDayNum() {
    let monthNum = document.querySelector("#month");
    let dayNum = document.querySelector("#day");
    let maxNum = 31;

    if (monthNum.value == 4 || monthNum.value == 6 || monthNum.value == 9 || monthNum.value == 11) {
        maxNum = 30;
    }

    if (monthNum.value == 2) {
        maxNum = 29;
    }

    if (dayNum.value > maxNum) {
        dayNum.value = maxNum
    }

    if (dayNum.value < 1) {
        dayNum.value = null;
    }
}

function highlightStartTimeBox() {
    let startTimeBox = document.querySelector("#start-time");
    startTimeBox.style.outlineColor = "#33ACFF";
}

function highlightEndTimeBox() {
    let endTimeBox = document.querySelector("#end-time");
    endTimeBox.style.outlineColor = "#33ACFF";
}

function setStartMeridian(meridian) {
    let startAmButton = document.querySelector("#start-am");
    let startPmButton = document.querySelector("#start-pm");

    if (meridian == 1) {
        startAmButton.style.background = "#33ACFF";
        startPmButton.style.backgroundColor = "white";
        startMeridian = "AM";
    } else {
        startAmButton.style.backgroundColor = "white";
        startPmButton.style.background = "#33ACFF";
        startMeridian = "PM";
    }

}

function setEndMeridian(meridian) {
    let endAmButton = document.querySelector("#end-am");
    let endPmButton = document.querySelector("#end-pm");

    if (meridian == 1) {
        endAmButton.style.background = "#33ACFF";
        endPmButton.style.backgroundColor = "white";
        endMeridian = "AM";
    } else {
        endAmButton.style.backgroundColor = "white";
        endPmButton.style.background = "#33ACFF";
        endMeridian = "PM";
    }
}

function loadNotifications() {
    location.href = "http://touchbase-api.s3-website-us-west-2.amazonaws.com/members/notifications" +
        "/notifications-page.html?memberId=" + memberId;
}

function loadEvents() {
    location.href = "https://touchbase-api.s3.us-west-2.amazonaws.com/members/events/events-page.html?memberId="+
        memberId+"&familyId="+familyId;
}

function loadFamily() {
    if (hasFamily) {
        location.href = "http://touchbase-api.s3-website-us-west-2.amazonaws.com/members/family/family-page.html?"
            +"memberId="+memberId+"&familyId="+familyId;
    } else {
        location.href = "http://touchbase-api.s3-website-us-west-2.amazonaws.com/members/family/joincreate/" +
            "create-join-page.html";
    }
}

function loadAccount() {
    location.href = "https://touchbase-api.s3.us-west-2.amazonaws.com/members/member-page.html?memberId="+memberId;
}
