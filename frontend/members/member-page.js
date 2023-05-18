const urlParams = new URLSearchParams(window.location.search);
const memberId = urlParams.get('memberId');

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

        const memberName = document.querySelector("#p-name");
        const memberBirthday = document.querySelector("#p-birthday");
        const memberPassword = document.querySelector("#p-password");
        const numUnread = document.querySelector("#p-unread");
        const memberId = document.querySelector("#p-id");

        memberName.innerText = name;
        memberBirthday.innerText = birthday;
        memberPassword.innerText = password;
        numUnread.innerText = unread;
        memberId.innerText = id;

        loadingDiv.style.display = "none";
        toolBarDiv.style.display = "block";
        memberPageDiv.style.display = "block";
    })


}

function loadNotifications() {
    location.href = "http://localhost:63342/touchbase-api/frontend/members/notifications/notifications-page.html?memberId=" + memberId;
}

function loadEvents() {

}

function loadFamily() {
    if (hasFamily) {
        location.href = "http://localhost:63342/touchbase-api/frontend/members/family/family-page.html?";
    } else {
        location.href = "http://localhost:63342/touchbase-api/frontend/joincreate/create-join-page.html";
    }
}

function loadAccount() {
    location.reload();
}

