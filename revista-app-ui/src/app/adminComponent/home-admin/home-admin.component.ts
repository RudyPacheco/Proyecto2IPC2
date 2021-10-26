import { Component, OnInit } from '@angular/core';
import { loginServices } from 'src/app/services/login/login.services';
import { usuarioLoged } from 'src/models/auth/usuarioLoged';

@Component({
  selector: 'app-home-admin',
  templateUrl: './home-admin.component.html',
  styleUrls: ['./home-admin.component.css']
})
export class HomeAdminComponent implements OnInit {
  nombreUsuario!: string;

  usuarioLoged!: usuarioLoged;
  constructor(private loginService: loginServices) { }




  impirmir(){

    console.log(this.loginService.getToken());
  }



  ngOnInit(): void {
    this.usuarioLoged=this.loginService.getUsuario();
  }

}
