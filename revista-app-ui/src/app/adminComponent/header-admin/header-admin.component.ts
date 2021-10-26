import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { loginServices } from 'src/app/services/login/login.services';

@Component({
  selector: 'app-header-admin',
  templateUrl: './header-admin.component.html',
  styleUrls: ['./header-admin.component.css']
})
export class HeaderAdminComponent implements OnInit {

  nombreUsuario:string="";

  constructor(private loginService:loginServices,private router:Router) { 
    this.nombreUsuario=this.loginService.usuario.usuario;
  }

  ngOnInit(): void {
  }

  salir(){
    this.loginService.eliminarToken();
    this.router.navigate(['login']);
  }


  perfil(){
    this.router.navigate(['MiPerfilE']);
  }
}
