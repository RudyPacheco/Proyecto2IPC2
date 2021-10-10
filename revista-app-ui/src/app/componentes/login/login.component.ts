import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { FlashMessagesModule } from 'flash-messages-angular';
import { usuarioLoged } from 'src/models/auth/usuarioLoged';
import { usuarioLogin } from 'src/models/auth/usuarioLogin';
import { loginServices } from 'src/app/services/login/login.services';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  loginForm!: FormGroup;

  constructor(private builder: FormBuilder,private loginServices: loginServices ,private router: Router) {
    this.loginForm = this.builder.group({
      nombre: ['', Validators.required],
      contrasenia: ['', Validators.required],
    });
  }

  enviar(values: any) {
    if (this.loginForm.valid) {
      console.log(values);
      this.loginServices.createLogin(this.loginForm.value)
    .subscribe((create: usuarioLoged) =>{
        this.loginForm.reset({
          nombre: '',
          contasenia: '',
        });
        let xd = create;
      console.log("created ");
      console.log(create);
        if (create.token!==undefined) {
          this.loginServices.agregarToken(create.token);
      console.log("TOKEN AP");
     // console.log(create.token)
      console.log(this.loginServices.getToken())
      this.router.navigate(['inicioED'])
        }else{
          console.log("error token")
        }

      
      } ,
      (error: any) => {
        console.log("error"+error);
      });
      
    }
  }

  ngOnInit(): void {}
}
