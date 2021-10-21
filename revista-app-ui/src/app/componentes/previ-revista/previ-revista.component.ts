import { Component, OnInit } from '@angular/core';
import { revistaService } from 'src/app/services/revista/revista.service';
import { revista } from 'src/models/revista/revista.model';

@Component({
  selector: 'app-previ-revista',
  templateUrl: './previ-revista.component.html',
  styleUrls: ['./previ-revista.component.css']
})
export class PreviRevistaComponent implements OnInit {

  array:string[]=[]
  revistaR:revista;
  constructor(private revsistaService:revistaService) {
      this.revistaR = new revista(0,"",0,"","",this.array,"","",true,);
   }

  ngOnInit(): void {
    this.revsistaService.emisorSeleccion.subscribe((revista:revista)=>{
      this.revistaR=revista;
    })
  }

}
