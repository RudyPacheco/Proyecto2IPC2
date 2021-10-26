import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { loginServices } from "../login/login.services";


@Injectable({
    providedIn: 'root'
  })

export class reportesAdminService {
    
    
    readonly APY_URL="http://localhost:8080/revistas-app-backend/";


    
    constructor(private httpClient:HttpClient,private loginService:loginServices) {   }

    // public verReporte(revista:string,fechaI:string,fechaF:string){
    //     return this.APY_URL+"reporteComentarioServlet";
    // }


    //reporte ganancia 
    public verReporteGanancia(revista:string,fechaI:string,fechaF:string):string{
        return this.APY_URL+"reporteGananciasAdminServlet?revista="+revista+"&fechaI="+fechaI+"&fechaF="+fechaF;
    }

    public descargarReporteGanancia(revista:string,fechaI:string,fechaF:string):string{
        return this.APY_URL+"reporteGananciasAdminServlet?revista="+revista+"&fechaI="+fechaI+"&fechaF="+fechaF+"&descargar=true";
    }

    //reporte popular
    public verReporteRevistaPopular(revista:string,fechaI:string,fechaF:string):string{
        return this.APY_URL+"reporteRevistaPopular?fechaI"+fechaI+"&fechaF="+fechaF;
    }

    public descargarReporteRevistaPopular(revista:string,fechaI:string,fechaF:string):string{
        return this.APY_URL+"reporteRevistaPopular?fechaI"+fechaI+"&fechaF="+fechaF+"&descargar=true";
    }

    public verReporteRevistaComentada(revista:string,fechaI:string,fechaF:string):string{
        return this.APY_URL+"reporteComentadas?fechaI"+fechaI+"&fechaF="+fechaF;
    }

    public descargarReporteRevistaComentada(revista:string,fechaI:string,fechaF:string):string{
        return this.APY_URL+"reporteComentadas?fechaI"+fechaI+"&fechaF="+fechaF+"&descargar=true";
    }



    

    


    // public verReporteGanancias(revista:string,fechaI:string,fechaF:string):string{
    //     return this.APY_URL+"reporteGananciasEServlet?revista="+revista+"&editor="+this.loginService.usuario.usuario+"&fechaI="+fechaI+"&fechaF="+fechaF;
    // }

    // public descargarReporteGanancias(revista:string,fechaI:string,fechaF:string):string{
    //     return this.APY_URL+"reporteGananciasEServlet?revista="+revista+"&editor="+this.loginService.usuario.usuario+"&fechaI="+fechaI+"&fechaF="+fechaF+"&descargar=true";
    // }



    


   
    




}