import { Component, OnInit } from '@angular/core';
import { edicionService } from 'src/app/services/revista/edicion.service';
import { edicionModel } from 'src/models/revista/edicion.model';
import { revista } from 'src/models/revista/revista.model';

@Component({
  selector: 'app-edicion-revista',
  templateUrl: './edicion-revista.component.html',
  styleUrls: ['./edicion-revista.component.css']
})
export class EdicionRevistaComponent implements OnInit {

  revistaSelect:revista;
  edicionesRevista:edicionModel[]=[];

  constructor(private edicionService:edicionService) {
    this.revistaSelect=this.edicionService.revistaSelect;
    this.edicionService.getlistaEdiciones().subscribe((ediciones:edicionModel[])=>{
      this.edicionesRevista=ediciones;
    })


   }

  ngOnInit(): void {
  }

}
