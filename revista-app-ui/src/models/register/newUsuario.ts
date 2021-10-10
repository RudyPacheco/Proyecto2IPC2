export class UsuarioNuevo {
   

    //private nombre: string;
    //private apellido: string;
    //private usuario: string;
    //private contrasenia: string;
     //categoria: number;
 

    constructor( private _nombre:string,apellido:string,usuario:string,contrasenia:string,private _categoria: number) {
       // this.nombre=nombre;
        //this.apellido=apellido;
        //this.usuario=usuario;
        //this.contrasenia=contrasenia;
        //this.categoria=categoria;

        

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

 

    public get Nombre(): string {
        return this._nombre;
    }

    
    public get categoria(): number {
        return this._categoria;
    }
    public set categoria(value: number) {
        this._categoria = value;
    }




}