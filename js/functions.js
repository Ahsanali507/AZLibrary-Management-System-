const email=document.getElementById('email');
const password=document.getElementById('password');

let validEmail=false;
let validPassword=false;

// $('#success').hide();
// $('#failure').hide();

email.addEventListener('blur',()=>{
        let regx=/^([_\-a-zA-Z0-9]+)@([_\-a-zA-Z0-9]+)\.([a-zA-Z]){3,7}$/;
        //let regx=/^[a-zA-Z0-9.! #$%&'*+/=? ^_`{|}~-]+@[a-zA-Z0-9-]+(?:\. [a-zA-Z0-9-]+)*$/;
        let str=email.value;
        if(regx.test(str)){
            email.classList.remove('is-invalid');
            validEmail=true;
            document.getElementById('submit-btn').disabled=false;
        }
        else{
            email.classList.add('is-invalid');
            validEmail=false;
            document.getElementById('submit-btn').disabled=true;
        }
})

password.addEventListener('blur',()=>{
    let regx=/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,15}$/;
    let str=password.value;
    if(regx.test(str)){
        password.classList.remove('is-invalid');
        validPassword=true;
        document.getElementById('submit-btn').disabled=false;
    }
    else{
        password.classList.add('is-invalid');
        validPassword=false;
        document.getElementById('submit-btn').disabled=true;
    }
})


// let submit=document.getElementById('submit');
// submit.addEventListener('click',(e)=>{
//     e.preventDefault();
//     console.log('you clicked the submit button');
//     if(validUser && validEmail && validPhone){
//         let success=document.getElementById('success');
//         success.classList.add('show');

//         let failure=document.getElementById('failure');
//         // failure.classList.remove('show');
//         // $('#failure').alert('close');
//         $('#failure').hide();
//         $('#success').show();
//     }
//     else{
//         let failure=document.getElementById('failure');
//         failure.classList.add('show');

//         let success=document.getElementById('success');
//         // success.classList.remove('show');
//         // $('#success').alert('close');
//         $('#success').hide();
//         $('#failure').show();
//     }

//})

















// //signup user,loginuser and adminlogin client side validations
// // name validation
// function validateName() {
//     let name=document.getElementById('name').value.toString();
//     if(name==""||name.length<3){
//         document.getElementById('nameErr').innerHTML="Invalid name";
//         document.getElementById('submit-btn').disabled=true;
//     }else{
//         document.getElementById('nameErr').innerHTML="";
//         document.getElementById('submit-btn').disabled=false;
//     }
// }

// // email validation
// function validateEmail() {
//     let emailRegex= /^[a-zA-Z0-9.! #$%&'*+/=? ^_`{|}~-]+@[a-zA-Z0-9-]+(?:\. [a-zA-Z0-9-]+)*$/;
//     let email=document.getElementById('email').value;
//     if(email==""){
//         document.getElementById('emailErr').innerHTML="Invalid email";
//         document.getElementById('submit-btn').disabled=true;
//     }
//     else{
//         if(emailRegex.test(email)){
//             document.getElementById('emailErr').innerHTML="";
//             document.getElementById('submit-btn').disabled=false;
//         }
//         else{
//             document.getElementById('emailErr').innerHTML="Invalid email";
//             document.getElementById('submit-btn').disabled=true;
//         }
//     }
// }

// // password validation
// function validatePassword() {
//     let password=document.getElementById('password').value.toString();
//     if(password==""||password.length<8){
//         document.getElementById('passwordErr').innerHTML="Password must be atleast 8 characters";
//         document.getElementById('submit-btn').disabled=true;
//     }
//     else{
//         document.getElementById('passwordErr').innerHTML="";
//         document.getElementById('submit-btn').disabled=false;
//     }
// }

// // address validation
// function validateAddress() {
//     let address=document.getElementById('address').value.toString();
//     if(address==""){
//         document.getElementById('addressErr').innerHTML="field should not be empty";
//         document.getElementById('submit-btn').disabled=true;
//     }
//     else{
//         document.getElementById('addressErr').innerHTML="";
//         document.getElementById('submit-btn').disabled=false;
//     }
// }





