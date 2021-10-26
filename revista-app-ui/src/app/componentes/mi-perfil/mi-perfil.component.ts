import { Component, OnInit } from '@angular/core';
import { loginServices } from 'src/app/services/login/login.services';
import { usuarioLoged } from 'src/models/auth/usuarioLoged';

@Component({
  selector: 'app-mi-perfil',
  templateUrl: './mi-perfil.component.html',
  styleUrls: ['./mi-perfil.component.css']
})
export class MiPerfilComponent implements OnInit {

  usuarioR:usuarioLoged;

  constructor(private loginService:loginServices) { 
    this.usuarioR=this.loginService.usuario;
  }

  ngOnInit(): void {
  }

}
