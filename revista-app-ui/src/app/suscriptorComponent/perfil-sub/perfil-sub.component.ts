import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-perfil-sub',
  templateUrl: './perfil-sub.component.html',
  styleUrls: ['./perfil-sub.component.css']
})
export class PerfilSubComponent implements OnInit {

  constructor(private router:Router) { }

  editarPerfil(){
    this.router.navigate(['EdicionPerfilS'])
  }

  ngOnInit(): void {
  }



  
}
