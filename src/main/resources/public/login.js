function verifyUser() {
	let classes = document.getElementById("form").className;

	if (classes.length > 1) {
		let username = document.getElementById("username").value;
		let pass = document.getElementById("password").value;
		let emp = document.getElementById("employee").checked;
		let mgr = document.getElementById("manager").checked;

		// Store Role
		if (emp) {
			sessionStorage.setItem("role", "employee");
		}

		if (mgr) {
			sessionStorage.setItem("role", "manager");
		}

		// Session Store 
		storeEmail(username);
		storeShhh(pass);

		// Verify Credentials

		login();

	}
    
}
function checkStorageCapable() {
    if (typeof (Storage) !== "undefined") {

    }
    else {
        showError();
    }
}
function showError() {
	document.getElementById("alert").style = "display: visible;";
}
function storeUsername(value1) {
	sessionStorage.setItem('username', value1);

}

function storeShhh(value1) {
	sessionStorage.setItem('shhh', value1);
}

async function login() {

	document.getElementById("spinners").style.display = "visible;";
	let response = await fetch(`${document.URL}${sessionStorage.getItem("role")}?email=${sessionStorage.getItem("email")}`);
	let info = await response.json();
	localStorage.setItem("json", info);
	// document.cookie = info;
	let data = JSON.stringify(info);
	localStorage.setItem('data', data);
	document.cookie = data;
	document.getElementById("spinners").style.display = "none;";

	if (info[0].password === sessionStorage.getItem('shhh')) {
		window.location = `${document.URL}${sessionStorage.getItem("role")}.html`;
	}




}