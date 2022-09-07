import { Component, OnInit } from '@angular/core';
import { QuizzesService } from 'src/app/services/quizzes.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-view-quizzes',
  templateUrl: './view-quizzes.component.html',
  styleUrls: ['./view-quizzes.component.css']
})
export class ViewQuizzesComponent implements OnInit {

  quizzes=[
    {
      qid:'',
      title:'',
      description:'',
      maxMarks:'',
      noOfQuestions:'',
      active:'',
      category:{
        title:''
      }
    },
    
  ]

  constructor(private service:QuizzesService) { }

  ngOnInit(): void {
    
    this.service.getQuiz().subscribe(
      (data:any)=>{
        this.quizzes=data;
        console.log(this.quizzes);
        
      },
      (error)=>{
        console.log(error);
        
      }
    );
  }
  // delete quiz
  deleteQuiz(id:any){
    this.service.deleteQuiz(id).subscribe(
      ()=>{
        this.quizzes=this.quizzes.filter((quiz)=>quiz.qid!=id)
        Swal.fire('Success','Quiz Delete Successfully','success');
      },
      (error)=>{
        Swal.fire('error','Quiz Delete Successfully','error');
      }
    )
  }

}
