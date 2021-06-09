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