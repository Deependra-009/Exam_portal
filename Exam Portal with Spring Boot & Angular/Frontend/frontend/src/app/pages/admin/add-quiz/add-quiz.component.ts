import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { CategoryService } from 'src/app/services/category.service';
import { QuizzesService } from 'src/app/services/quizzes.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-add-quiz',
  templateUrl: './add-quiz.component.html',
  styleUrls: ['./add-quiz.component.css']
})
export class AddQuizComponent implements OnInit {

  category=[
    {
      cid:123,
      title:'programing'
    }
  ]

  addQuiz={
    title:'',
    description:'',
    maxMarks:'',
    noOfQuestions:'',
    active:true,
    category:{
      cid:''
    }
  }

  constructor(
    private service:CategoryService,
    private mat:MatSnackBar,
    private quizservice:QuizzesService
  ) { }

  ngOnInit(): void {

    this.service.category().subscribe(
      (data:any)=>{
        this.category=data;
        console.log(data);
        
      },
      (error)=>{
        console.log(error);
        Swal.fire('error',"Something is wrong")
      }
    )
  }

  addQuizData(){
    console.log(this.addQuiz);

    if(this.addQuiz.title.trim()=='' || this.addQuiz.title==null){
      this.mat.open("Titile Required!!")
      return;
    }
    else if(this.addQuiz.description.trim()=='' || this.addQuiz.description==null){
      this.mat.open("Titile Required!!")
      return;
    }
    
    // call server

    this.quizservice.addQuiz(this.addQuiz).subscribe(
      (data:any)=>{
        Swal.fire('Success',"Quiz is Added",'success')
        this.addQuiz={
          title:'',
          description:'',
          maxMarks:'',
          noOfQuestions:'',
          active:true,
          category:{
            cid:'',
          }
        }
      },
      (error)=>{
        console.log(error);
        Swal.fire('error',"Something is wrong")
        
      }
    )
    
  }

}
