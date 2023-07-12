const urlParams = new URLSearchParams(window.location.search);
const memberId = "5763bd7a-7c6e-4370-9d33-96e5a761d756";

let hasFamily;
let familyId;

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

    axios.get("https://49042ah3j2.execute-api.us-west-2.amazonaws.com/beta/member/" + memberId +
                              "/notifications", headers).then((res) => {
        console.log(res.data.member);
        if (res.data.errorMessage != null) {
            alert(res.data.errorMessage);
            location.reload();
        } else {
           console.log(res.data);

            let memberNotifications = res.data.notifications;

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
    location.href = "http://touchbase-api.s3-website-us-west-2.amazonaws.com/members/notifications" +
                        "/notifications-page.html?memberId=" + memberId;
}

function loadEvents() {
    if (hasFamily) {
        location.href = "http://touchbase-api.s3.us-west-2.amazonaws.com/members/events/events-page.html?memberId="+
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

