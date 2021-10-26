import { Component, OnInit } from '@angular/core';
import { editorService } from 'src/app/services/revista/editorInfo.service';
import { usuarioLoged } from 'src/models/auth/usuarioLoged';

@Component({
  selector: 'app-view-editperfil',
  templateUrl: './view-editperfil.component.html',
  styleUrls: ['./view-editperfil.component.css']
})
export class ViewEditperfilComponent implements OnInit {

  tags:string[]=[];
  editorR:usuarioLoged=new usuarioLoged("","","","",this.tags,2,"");

  constructor(private editorService:editorService) {
    this.editorService.getInfoEditor().subscribe((usr:usuarioLoged)=>{
      this.editorR=usr;
    });
   }


  ngOnInit(): void {
  }

}
