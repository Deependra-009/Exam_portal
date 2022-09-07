import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseurl from './URL';

@Injectable({
  providedIn: 'root'
})
export class QuizzesService {

  constructor(
    private http:HttpClient
  ) { }

  public getQuiz(){
    return this.http.get(`${baseurl}/quiz/get-all`);
  }

  public addQuiz(data:any){
    return this.http.post(`${baseurl}/quiz/add`,data);
  }

  public deleteQuiz(id:any){
    return this.http.delete(`${baseurl}/quiz/delete/${id}`);
  }
}
