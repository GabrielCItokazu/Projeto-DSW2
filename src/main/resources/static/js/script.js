var myVar;

function myFunction_load() {
	myVar = setTimeout(showPage, 1000);
}

function showPage() {
	document.getElementById("loader").style.display = "none";
	document.getElementById("myDiv").style.display = "block";
}

//

var tabelas = document.querySelector("table");
tabelas.setAttribute("class", "table table-bordered table-striped table-hover");

const elemento = document.getElementsByTagName("tr");
var inputList = Array.prototype.slice.call(elemento);
inputList.forEach(myFunction_iter_table);

function myFunction_iter_table(item, index) {

    if (index % 2 ==  0){
        elemento[index].style.backgroundColor = "#7FFF00"

    }
    else{
        elemento[index].style.backgroundColor = "#FFD700"
    }
}

/* validação login*/
const form  = document.getElementById('formulario')

function validaForm(e) {
    const email = document.getElementById('username').value
    const emailError = document.querySelector('#username + span.error')
    let erroMsg = ""
    var submitOk = "true"
    let emailFormat = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/

    if (!email.match(emailFormat)) {
        erroMsg = "erro carai"
        submitOk = "false"
    }
    emailError.textContent = erroMsg

    if (submitOk == "false") {
        return false
    }
    else {
        e.submit()
    }
}