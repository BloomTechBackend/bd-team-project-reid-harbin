const urlParams = new URLSearchParams(window.location.search);
const memberId = urlParams.get('memberId');

let hasFamily;

let headers = { authorization: {
        'x-api-key': 'ROhDefLTvE9WkWAYyBULD86cNpB2HWKL4fTJL3WX'
    }
}

const toolBarDiv = document.querySelector(".tool-bar");
const notificationsPageDiv = document.querySelector(".notifications-page");
const loadingDiv = document.querySelector(".loading");

window.onload = async function(evt) {
    evt.preventDefault();

    loadingDiv.style.display = "block";
    toolBarDiv.style.display = "none";
    notificationsPageDiv.style.display = "none";

    axios.get("https://49042ah3j2.execute-api.us-west-2.amazonaws.com/beta/" + memberId, headers).then((res) => {
        console.log(res.data.member);
        if (res.data.errorMessage != null) {
            alert(res.data.errorMessage);
            location.reload();
        } else {
           console.log(res.data);

            let memberNotifications = res.data.member.notifications;
            hasFamily = res.data.member.memberHasFamily;

            const notificationsDiv = document.querySelector(".notifications");

            for (let i = 0; i < memberNotifications.length; i++) {
                let h1 = document.createElement("h1");
                h1.innerText = memberNotifications[i].notificationHeadline +
                    " | From: " + memberNotifications[i].notificationSenderName +
                     " | " + memberNotifications[i].notificationDate;
                h1.setAttribute('id', 'header'+ i);

                let p = document.createElement("p");
                p.innerText = memberNotifications[i].notificationDescription;

                const button = document.createElement('button');
                button.setAttribute('id', 'button' + i);
                button.textContent = "DELETE";
                button.onclick = function() {
                    removeButton(i);
                }

                h1.append(button);
                notificationsDiv.append(h1)
                h1.append(p);
            }

        }

        loadingDiv.style.display = "none";
        toolBarDiv.style.display = "block";
        notificationsPageDiv.style.display = "block";

    })
}

function removeButton(index) {
        const h1 = document.querySelector("#header" + index);
        const button = document.querySelector("#button" + index);
        h1.remove();
        button.remove();
    axios.put("https://49042ah3j2.execute-api.us-west-2.amazonaws.com/beta/" +
    memberId + "/notifications?notificationIndex=" + index, headers).then((res) => {
        console.log(res);
        location.reload();
    })
}

function loadNotifications() {
    location.reload();
}

function loadEvents() {

}

function loadFamily() {
    if (!hasFamily) {
        location.href = "http://localhost:63342/touchbase-api/frontend/members/family/create-join-page.html?memberId=" + memberId;
    } else {
        location.href = "http://localhost:63342/touchbase-api/frontend/members/family/family-page.html";
    }
}

function loadAccount() {
    //"/members/member-page.html?memberId="
    location.href = "http://localhost:63342/touchbase-api/frontend/members/member-page.html?memberId=" + memberId;
}

