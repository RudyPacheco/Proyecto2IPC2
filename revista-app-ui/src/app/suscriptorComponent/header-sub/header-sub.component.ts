import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { loginServices } from 'src/app/services/login/login.services';

@Component({
  selector: 'app-header-sub',
  templateUrl: './header-sub.component.html',
  styleUrls: ['./header-sub.component.css']
})
export class HeaderSubComponent implements OnInit {

  @Input() nombreUsuario:string="";


  constructor(private router:Router,private loginService:loginServices) { }

  ngOnInit(): void {
  }


  salir(){
    this.loginService.eliminarToken();
    
    this.router.navigate(['login']);
  
  }

}
