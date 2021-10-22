import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { loginServices } from 'src/app/services/login/login.services';

@Component({
  selector: 'app-header-editor',
  templateUrl: './header-editor.component.html',
  styleUrls: ['./header-editor.component.css']
})
export class HeaderEditorComponent implements OnInit {

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


}
