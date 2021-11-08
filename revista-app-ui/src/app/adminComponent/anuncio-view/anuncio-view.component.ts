import { Component, OnInit } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { anuncioService } from 'src/app/services/anuncio/anuncio.service';
import { loginServices } from 'src/app/services/login/login.services';
import { anuncioModel } from 'src/models/anuncio/anuncio.model';

@Component({
  selector: 'app-anuncio-view',
  templateUrl: './anuncio-view.component.html',
  styleUrls: ['./anuncio-view.component.css']
})
export class AnuncioViewComponent implements OnInit {

  anuncios: anuncioModel[] = [];
  allAnuncios!:anuncioModel[]

  constructor(private sanitizer:DomSanitizer,private anuncioService:anuncioService,private loginService:loginServices) { 
    this.anuncioService.getlistaAnuncios(this.loginService.usuario.usuario).subscribe((anuncios:anuncioModel[])=>{
      this.allAnuncios=anuncios;
      this.anuncios.push(this.allAnuncios[this.generarNumeroAleatorio(0,this.allAnuncios.length-1)]);
      let tiempoEsper=15000;
      setInterval(()=>{
        this.anuncios=[];
      //  for (let i = 0; i < 3; i++) {
          this.anuncios.push(this.allAnuncios[this.generarNumeroAleatorio(0,this.allAnuncios.length-1)]);
          
        //}
      },tiempoEsper)
      
      //this.anuncios=anuncios;


    });

  }


  buscarImagen(anuncio:anuncioModel): any{
    return this.anuncioService.downloadImage(anuncio);
  }

  formatearLink(link: string): any{
    console.log(link)
    const partes: string[]  = link.split("=");
    const video: string = partes[1];
    const newlink = `https://www.youtube.com/embed/${video}?loop=1&autoplay=1&playlist=${video}&controls=0&mute=1`; 
    return this.sanitizer.bypassSecurityTrustResourceUrl(newlink);
  }


  generarNumeroAleatorio(inicio: number, fin: number): number {
    return Math.floor(inicio + Math.random() * (fin - inicio + 1));
  }



  ngOnInit(): void {
  }

}
