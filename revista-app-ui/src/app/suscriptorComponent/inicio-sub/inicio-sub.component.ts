import { Component, OnInit } from '@angular/core';
import { loginServices } from 'src/app/services/login/login.services';
import { registroServices } from 'src/app/services/registro/registro.service';
import { usuarioLoged } from 'src/models/auth/usuarioLoged';

@Component({
  selector: 'app-inicio-sub',
  templateUrl: './inicio-sub.component.html',
  styleUrls: ['./inicio-sub.component.css']
})
export class InicioSubComponent implements OnInit {

  usuarioLoged!: usuarioLoged;

  constructor(private registroService:registroServices,private loginService:loginServices) { }

  ngOnInit(): void {
    this.usuarioLoged=this.loginService.getUsuario();
  }

  click(){
    console.log(this.loginService.getToken());
  }



}
