import { Component, OnInit } from '@angular/core';
import { loginServices } from 'src/app/services/login/login.services';
import { usuarioLoged } from 'src/models/auth/usuarioLoged';

@Component({
  selector: 'app-inicio-editor',
  templateUrl: './inicio-editor.component.html',
  styleUrls: ['./inicio-editor.component.css']
})
export class InicioEditorComponent implements OnInit {

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
