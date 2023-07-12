const urlParams = new URLSearchParams(window.location.search);
const memberId = urlParams.get('memberId');

let familyId;
let hasFamily;

let headers = { authorization: {
        'x-api-key': 'ROhDefLTvE9WkWAYyBULD86cNpB2HWKL4fTJL3WX'
    }
}

const toolBarDiv = document.querySelector(".tool-bar");
const memberPageDiv = document.querySelector(".member-page");
const loadingDiv = document.querySelector(".loading");

window.onload = async function(evt) {
    evt.preventDefault();

    loadingDiv.style.display = "block";
    toolBarDiv.style.display = "none";
    memberPageDiv.style.display = "none";

    let responseMember;
    axios.get("https://49042ah3j2.execute-api.us-west-2.amazonaws.com/beta/" + memberId, headers).then((res) => {
        console.log(res.data.member);
        if (res.data.member === null) {
            alert(res.data.errorMessage);
            location.href = "index.html";
        }

        console.log(res.data);

        let name = res.data.member.memberName;
        let birthday = res.data.member.memberBirthday;
        let password = res.data.member.memberPassword;
        let unread = res.data.member.notifications.length;
        let id = res.data.member.memberId;
        hasFamily = res.data.member.memberHasFamily;
        familyId = res.data.member.familyId;

        const memberName = document.querySelector("#p-name");
        const memberBirthday = document.querySelector("#p-birthday");
        const memberPassword = document.querySelector("#p-password");
        const numUnread = document.querySelector("#p-unread");

        memberName.innerText = name;
        memberBirthday.innerText = birthday;
        memberPassword.innerText = password;
        numUnread.innerText = unread;

        loadingDiv.style.display = "none";
        toolBarDiv.style.display = "block";
        memberPageDiv.style.display = "block";
    })


}

function loadNotifications() {
    location.href = "http://touchbase-api.s3-website-us-west-2.amazonaws.com/members/notifications" +
                        "/notifications-page.html?memberId=" + memberId;
}

function loadEvents() {
    if (hasFamily) {
        location.href = "https://touchbase-api.s3.us-west-2.amazonaws.com/members/events/events-page.html?memberId="+
            memberId+"&familyId="+familyId;
    } else {
        alert("You need to join or create a family before you can access events");
    }
}

function loadFamily() {
    if (hasFamily) {
        location.href = "http://touchbase-api.s3-website-us-west-2.amazonaws.com/members/family/family-page.html?"
                         +"memberId="+memberId+"&familyId="+familyId;
    } else {
        location.href = "https://touchbase-api.s3.us-west-2.amazonaws.com/members/family/create-join-page.html";
    }
}

function loadAccount() {
    location.href = "https://touchbase-api.s3.us-west-2.amazonaws.com/members/member-page.html?memberId="+memberId;
}

