/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resumebuilder;

import java.util.ArrayList;

/**
 *
 * @author varsha
 */
public class ResumeCollection {
    private ArrayList<Resume> resume;

    public ResumeCollection(){
        resume = new ArrayList<Resume>();
    }
            
    public ArrayList<Resume> getResume() {
        return resume;
    }

    public void setResume(ArrayList<Resume> resume) {
        this.resume = resume;
    }
    
    public Resume addResume()
   {
      Resume rs = new Resume();
      resume.add(rs);
      return rs;
      
   }
   public void removeResume(Resume rs)
   {
      resume.remove(rs);
   }   
   
   
}
