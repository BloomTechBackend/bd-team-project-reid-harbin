const createFamilyForm = document.querySelector("#create-family-form");
const joinFamilyForm = document.querySelector("#join-family-form");
let memberId;


let headers = { authorization: {
        'x-api-key': 'ROhDefLTvE9WkWAYyBULD86cNpB2HWKL4fTJL3WX'
    }
}


window.onload = function() {
    const urlParams = new URLSearchParams(window.location.search);
    memberId = urlParams.get('memberId');
}

createFamilyForm.onsubmit = async function(evt) {
    evt.preventDefault();


    let loadingDiv = document.querySelector(".loading");
    let containerDiv = document.querySelector(".container");
    containerDiv.style.display = "none";
    loadingDiv.style.display = "block";

    let familyName = document.getElementById("create-family-name").value;
    let familyPassword = document.getElementById("create-family-password").value;

    axios.post("https://49042ah3j2.execute-api.us-west-2.amazonaws.com/beta/"+memberId+"/family", {
        "familyCreatorId": memberId,
        "familyName": familyName,
        "familyPassword": familyPassword
    }, { authorization: {
        'x-api-key': 'ROhDefLTvE9WkWAYyBULD86cNpB2HWKL4fTJL3WX'
    }}).then((res) => {
        if (res.data.errorMessage != null) {
            alert(res.data.errorMessage);
        } else {
            location.href = "https://touchbase-api.s3.us-west-2.amazonaws.com/members/member-page.html?memberId="+memberId;
        }
    });
}

joinFamilyForm.onsubmit = async function(evt) {
    evt.preventDefault();

    let familyId = document.getElementById("join-family-id").value;
    let familyPassword = document.getElementById("join-family-password").value;
    let familyName = document.getElementById("join-family-name").value;

    axios.put("https://49042ah3j2.execute-api.us-west-2.amazonaws.com/beta/"+ memberId + "/family", {
        "familyId": familyId,
        "memberId": memberId,
        "familyPassword": familyPassword,
        "familyName": familyName
    }, headers).then((res) => {
        if (res.data.errorMessage != null) {
            alert(res.data.errorMessage);
        } else {
            location.href = "https://touchbase-api.s3.us-west-2.amazonaws.com/members/member-page.html?memberId="+memberId;
        }
    });

}