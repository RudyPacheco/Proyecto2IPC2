import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-perfil-edit',
  templateUrl: './perfil-edit.component.html',
  styleUrls: ['./perfil-edit.component.css']
})
export class PerfilEditComponent implements OnInit {

  constructor(private router:Router) { }

  editarPerfil(){
    this.router.navigate(['EdicionPerfilE'])
  }


  ngOnInit(): void {
  }

}
