import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-form-editperfilsub',
  templateUrl: './form-editperfilsub.component.html',
  styleUrls: ['./form-editperfilsub.component.css']
})
export class FormEditperfilsubComponent implements OnInit {

  constructor(private router:Router) { }

  editarPerfil(){
    this.router.navigate(['EdicionPerfilS']);
  }




  ngOnInit(): void {
  }

}
