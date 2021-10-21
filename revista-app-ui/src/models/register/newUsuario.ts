export class UsuarioNuevo {
   

     nombre: string;
    apellido: string;
     usuario: string;
     contrasenia: string;
     tipoCuenta: number;
 

    constructor( private nombreR:string,apellido:string,usuario:string,contrasenia:string,private categoria: number) {
        this.nombre=nombreR;
        this.apellido=apellido;
        this.usuario=usuario;
        this.contrasenia=contrasenia;
        this.tipoCuenta=categoria;

      
    }

   
  


   // public getNombre(){
     //   return this.nombre;
   // }

   // public getApellido(){
     //   return this.apellido;
   // }

  //  public getUsuaraio(){
    //    return this.usuario;
   // }

//    public getContrasenia(){
  //      return this.contrasenia;
   // }

    

}