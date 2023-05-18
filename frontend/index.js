const signUpForm = document.getElementById("create-member-form");
const signInForm = document.getElementById("sign-in-form");

const signUpButton = document.getElementById("sign-up-button");

let url =  'https://49042ah3j2.execute-api.us-west-2.amazonaws.com/beta/members';

let headers = {
  authorization: {
    'x-api-key': 'ROhDefLTvE9WkWAYyBULD86cNpB2HWKL4fTJL3WX'
  }

}

const signUpDiv = document.querySelector(".sign-up-page");
const signInDiv = document.querySelector(".sign-in-page");
const loadingDiv = document.querySelector(".loading");

function loadSignIn() {
    signUpDiv.style.display = "none";
    signInDiv.style.display = "block";

}

function loadSignUp() {
    signUpDiv.style.display = "block";
    signInDiv.style.display = "none";
}

function loadLoading() {
}

signUpForm.onsubmit = async function(evt) {
    evt.preventDefault();

    signInDiv.style.display = "none";
    signUpDiv.style.display = "none";
    loadingDiv.style.display = "block";

    let memberName = document.getElementById("member-name").value;
    let memberPassword = document.getElementById("member-password").value;
    let memberBirthday = document.getElementById("member-birthday").value;

    axios.post("https://49042ah3j2.execute-api.us-west-2.amazonaws.com/beta/members", {
        "name": memberName,
        "password": memberPassword,
        "birthday": memberBirthday
    }, { authorization: {
        'x-api-key': 'ROhDefLTvE9WkWAYyBULD86cNpB2HWKL4fTJL3WX'
    }}).then((res) => {
        if (res.data.errorMessage != null) {
            alert(res.data.errorMessage)
            location.reload();
        } else {
            location.href = "http://localhost:63342/touchbase-api/frontend/members/member-page.html?memberId=" + res.data.member.memberId;
        }
    });
}

signInForm.onsubmit = async function(evt) {
    evt.preventDefault();

    let id = document.getElementById("member-id").value;

    signInDiv.style.display = "none";
    signUpDiv.style.display = "none";
    loadingDiv.style.display = "block";

    axios.get("https://49042ah3j2.execute-api.us-west-2.amazonaws.com/beta/" + id, headers).then((res) => {
        console.log(res.data);
        if (res.data.errorMessage != null) {
            alert(res.data.errorMessage)
            location.reload();
        } else {
            location.href = "http://localhost:63342/touchbase-api/frontend/members/member-page.html?memberId=" + res.data.member.memberId;
        }
    });
}

