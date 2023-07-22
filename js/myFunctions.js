const names=document.getElementById('name');
const email=document.getElementById('email');
const password=document.getElementById('password');
const address=document.getElementById('address');

let validName=false;
let validEmail=false;
let validPassword=false;
let validAddress=false;

// $('#success').hide();
// $('#failure').hide();

names.addEventListener('blur',()=>{
    let regx=/^[a-zA-Z]([a-zA-z0-9\s]){2,18}$/;
    let str=names.value;
    if(regx.test(str)){
        //alert("matched");
        names.classList.remove('is-invalid');
        validName=true;
        document.getElementById('submit-btn').disabled=false;
    }
    else{
        //alert("not matched");
        names.classList.add('is-invalid');
        validName=false;
        document.getElementById('submit-btn').disabled=true;
    }
})

email.addEventListener('blur',()=>{
        let regx=/^([_\-a-zA-Z0-9]+)@([_\-a-zA-Z0-9]+)\.([\.a-zA-Z]){3,7}$/;
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

address.addEventListener('blur',()=>{
    let str=address.value;
    if(str!=""){
        address.classList.remove('is-invalid');
        validAddress=true;
        document.getElementById('submit-btn').disabled=false;
    }
    else{
        address.classList.add('is-invalid');
        validAddress=false;
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