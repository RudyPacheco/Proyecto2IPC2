import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { loginServices } from 'src/app/services/login/login.services';

@Component({
  selector: 'app-header-sub',
  templateUrl: './header-sub.component.html',
  styleUrls: ['./header-sub.component.css']
})
export class HeaderSubComponent implements OnInit {

  nombreUsuario:string="";


  constructor(private router:Router,private loginService:loginServices) {
    this.nombreUsuario=this.loginService.usuario.usuario;

   }

  ngOnInit(): void {
  }


  salir(){
    this.loginService.eliminarToken();
    
    this.router.navigate(['login']);
  
  }

  perfil(){
    this.router.navigate(['MiPerfilS']);
  }



}
