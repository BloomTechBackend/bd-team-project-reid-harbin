const createFamilyForm = document.querySelector("#create-family-form");
const joinFamilyForm = document.querySelector("#join-family-form");

let headers = { authorization: {
        'x-api-key': 'ROhDefLTvE9WkWAYyBULD86cNpB2HWKL4fTJL3WX'
    }
}


createFamilyForm.onsubmit = async function(evt) {
    evt.preventDefault();

    let familyName = document.getElementById("create-family-name").value;
    let familyPassword = document.getElementById("create-family-password").value;
    let memberId = document.getElementById("create-member-id").value;
    axios.post("https://49042ah3j2.execute-api.us-west-2.amazonaws.com/beta/create-family?", {
        "familyCreatorId": memberId,
        "familyName": familyName,
        "familyPassword": familyPassword
    }, { authorization: {
        'x-api-key': 'ROhDefLTvE9WkWAYyBULD86cNpB2HWKL4fTJL3WX'
    }}).then((res) => {
        if (res.data.errorMessage != null) {
            alert(res.data.errorMessage);
        } else {
            location.href = "http://localhost:63342/touchbase-api/frontend/members/member-page.html?memberId=" + memberId;
        }
    });
}

joinFamilyForm.onsubmit = async function(evt) {
    evt.preventDefault();

    let familyId = document.getElementById("join-family-id").value;
    let familyPassword = document.getElementById("join-family-password").value;
    let familyName = document.getElementById("join-family-name").value;
    let memberId = document.getElementById("join-member-id").value;

    axios.put("https://49042ah3j2.execute-api.us-west-2.amazonaws.com/beta/join-family", {
        "familyId": familyId,
        "memberId": memberId,
        "familyPassword": familyPassword,
        "familyName": familyName
    }, headers).then((res) => {
        if (res.data.errorMessage != null) {
            alert(res.data.errorMessage);
        } else {
            location.href = "http://localhost:63342/touchbase-api/frontend/members/member-page.html?memberId=" + memberId;
        }
    });

}