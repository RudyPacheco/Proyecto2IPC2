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

  mensaje: string="";
  showError: boolean= false;


  constructor(private builder: FormBuilder,private loginServices: loginServices ,private router: Router) {
    this.loginForm = this.builder.group({
      nombre: ['', Validators.required],
      contrasenia: ['', Validators.required],
      fechaActual:['',Validators.required]
    });
  }

  enviar(values: any) {
    if (this.loginForm.valid) {
      
      console.log(this.loginForm.get("fechaActual")?.value);
      this.loginServices.fechaActual=this.loginForm.get("fechaActual")?.value;
      console.log(this.loginServices.fechaActual);
      console.log(values);
      this.loginServices.createLogin(this.loginForm.value)
    .subscribe((create: usuarioLoged) =>{
       this.resetForm();
        let xd = create;
      console.log("created ");
      console.log(create);
      console.log(create.token);

        if (create.token!==undefined) {
          this.loginServices.agregarToken(create.token);
          this.loginServices.agregarUsuario(create);
        
        
      console.log("TOKEN AP");

     // console.log(create.token)
      console.log(this.loginServices.getToken())
          if (create.tipoCuenta==1) {
            this.router.navigate(['inicioSUB']);
          }else if (create.tipoCuenta==2) {
            this.router.navigate(['inicioED']);
          }else if (create.tipoCuenta==3){
            this.router.navigate(['InicioAdmin']);
          }
        }else{
          console.log("error token")
        }
      } ,
      (error: any) => {
        console.log("error"+error);
        this.showError = true;
        this.mensaje= error.error.mensaje;
        this.resetForm();
      });
      
    }
  }

  ngOnInit(): void {}

  resetForm(){
    this.loginForm.reset({
      nombre: '',
      contasenia: '',
    });
  }


}
