       package com.spring.implementation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class ResetPasswordApplication {

	public static void main(String[] args) {
		 SpringApplication.run(ResetPasswordApplication.class, args);

	}

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/header")
	public String header() {
		return "header";
	}

	@GetMapping("/aboutus")
	public String aboutus() {
		return "aboutus";
	}
	
	  
	    @GetMapping("/course")
	    public String course() {
	        return "course";
	    }
	    
	  
	    @GetMapping("/Student")
	    public String Student() {
	        return "Student";
	    }
	    @GetMapping("/Home")
	    public String Home() {
	        return "index";  
	    }       
	    @GetMapping("/history")
	    public String history() {
	        return "ReadMore/history";
	    }

	    @GetMapping("/polity")
	    public String polity() {
	        return "ReadMore/polity";
	        
	    }
	    @GetMapping("/hindi")
	    public String hindi() {
	        return "ReadMore/hindi";
	    }
	    @GetMapping("/economics")
	    public String economics() {
	        return "ReadMore/economics";
	    }
	    @GetMapping("/public administration")
	    public String publicadministration() {
	        return "ReadMore/public administration";
	    }
	    
	    @GetMapping("/chemistry")
	    public String chemistry() {
	        return "ReadMore/chemistry";
	    }
	    
	    @GetMapping("/physics")
	    public String physics() {
	        return "ReadMore/physics";
	    }
	    @GetMapping("/agriculture")
	    public String agriculture() {
	        return "ReadMore/agriculture";
	    }
	    
	    @GetMapping("/maths")
	    public String maths() {
	        return "ReadMore/maths";
	    }
	    @GetMapping("/biology")
	    public String biology() {
	        return "ReadMore/biology";
	    }
	    
	    
	   
	    
	    	@GetMapping("/itimain")
	    	public String itimain() {
	    		return "ITI/itimain";
	    	}
	    		@GetMapping("/index")
	    		public String index() {
	    			return "index";
	    		}
	    		
	    		@GetMapping("/special")
	    		public String special() {
	    			return "ITI/special";
	    		}
	    		@GetMapping("/fitter")
	    		public String fitter() {
	    			return "ITI/all_trade/fitter/fitter";
	    		}

	    		@GetMapping("/take_quiz")
	    		public String take_quiz() {
	    			return "ITI/all_trade/fitter/take_quiz";
	    		}
	    		
	    				
	    		@GetMapping("/electronics")
	    		public String electronics() {
	    			return "ITI/all_trade/electronics/electronics";
	    		}
	    		@GetMapping("/test2")
	    		public String test2() {
	    			return "ITI/all_trade/electronics/test";
	    		}
	    		
	    		@GetMapping("/machinist")
	    		public String machinist() {
	    			return "ITI/all_trade/machinist/machinist";
	    		}
	    		@GetMapping("/electrician")
	    		public String electrician() {
	    			return "ITI/all_trade/electrician/electrician";
	    		}
	    		@GetMapping("/test")
	    		public String test1() {
	    			return "ITI/all_trade/electrician/test";
	    		}
	    		
	    		
	    		@GetMapping("/copa")
	    		public String copa() {
	    			return "ITI/all_trade/copa/copa";
	    		}
	    		@GetMapping("/copaquiz")
	    		public String copaquiz() {
	    			return "ITI/all_trade/copa/copaquiz";
	    		}
	    		
	    		@GetMapping("/networking")
	    		public String networking() {
	    			return "ITI/all_trade/Networking/networking";
	    		}
	    		@GetMapping("/welder")
	    		public String welder() {
	    			return "ITI/all_trade/welder/welder";
	    		}
	    		@GetMapping("/test4")
	    		public String test4() {
	    			return "ITI/all_trade/welder/test";
	    		}
	    		@GetMapping("/tarner")
	    		public String tarner() {
	    			return "ITI/all_trade/tarner/tarner";
	    		}
	    		@GetMapping("/test3")
	    		public String test3() {
	    			return "ITI/all_trade/tarner/test";
	    		}
	    		@GetMapping("/beautician")
	    		public String beautician() {
	    			return "ITI/all_trade/beautician/beautician";
	    		}
	    		@GetMapping("/carpenter")
	    		public String carpenter() {
	    			return "ITI/all_trade/carpenter/carpenter";
	    		}
	    		
	    		 @GetMapping("/Back to Topics")
	    		    public String BacktoTopics() {
	    		    return "ITI/itimain";
	    		    }
	    		    @GetMapping("/web_design")
	    		    public String web_design() {
	    		    return "IT_Topics/web_design";
	    		    }	
	    		    @GetMapping("/aws")
	    		    public String aws() {
	    		    return "IT_Topics/aws";
	    		    }	
	    		    @GetMapping("/python")
	    		    public String python() {
	    		    return "IT_Topics/python";
	    		    }
	    		    @GetMapping("/java")
	    		    public String java() {
	    		    return "IT_Topics/java";
	    		    }
	    		    @GetMapping("/php")
	    		    public String php() {
	    		    return "IT_Topics/php";
	    		    }
	    		    @GetMapping("/mysql")
	    		    public String mysql() {
	    		    return "IT_Topics/mysql";
	    		    }
	    		    @GetMapping("/excel")
	    		    public String excel() {
	    		    return "IT_Topics/excel";
	    		    }
	    		    
	    
	    @GetMapping("/GovtMain")
	    public String GovtMain() {
	    return "govtmain";
	    }
	    @GetMapping("/UPSC_Civil_Services")
	    public String UPSC_Civil_Services() {
	    return "Govt.html/upsc_explore";
	    }
	    @GetMapping("/Banking_Exams_Preparation")
	    public String Banking_Exams_Preparation() {
	    return "Govt.html/bank_explore";
	    }
	    @GetMapping("/SSC_Exam_Preparation")
	    public String SSC_Exam_Preparation() {
	    return "Govt.html/ssc_explore";
	    }
	    @GetMapping("/Railways_Exam_Preparation")
	    public String Railways_Exam_Preparation() {
	    return "Govt.html/rail_explore";
	    }
	    @GetMapping("/State_PCS_Exam_Preparation")
	    public String State_PCS_Exam_Preparation() {
	    return "Govt.html/spcs_explore";
	    }
	    @GetMapping("/Defence_Exam_Preparation")
	    public String Defence_Exam_Preparation() {
	    return "Govt.html/defence_explore";
	    }
	    
	    @GetMapping("/Eng_mock1")
	   	public String Eng_mock1() {
	   		return "mock/Eng.html/Eng_mock1";
	   	}
	    @GetMapping("/Eng_mock2")
	   	public String Eng_mock2() {
	   		return "mock/Eng.html/Eng_mock2";
	   	}
	    @GetMapping("/Eng_mock3")
	   	public String Eng_mock3() {
	   		return "mock/Eng.html/Eng_mock3";
	   	}
	    @GetMapping("/Eng_mock4")
	   	public String Eng_mock4() {
	   		return "mock/Eng.html/Eng_mock4";
	   	}
	    @GetMapping("/Eng_mock5")
	   	public String Eng_mock5() {
	   		return "mock/Eng.html/Eng_mock5";
	   	}
	   	@GetMapping("/Eng_mock6")
	   	public String Eng_mock6() {
	   		return "mock/Eng.html/Eng_mock6";
	   	}
	   	@GetMapping("/Eng_mock7")
	   	public String Eng_mock7() {
	   		return "mock/Eng.html/Eng_mock7";
	   	}
	   	@GetMapping("/Eng_mock8")
	   	public String Eng_mock8() {
	   		return "mock/Eng.html/Eng_mock8";
	   	}
	   	@GetMapping("/Eng_mock9")
	   	public String Eng_mock9() {
	   		return "mock/Eng.html/Eng_mock9";
	   	}
	   	@GetMapping("/Eng_mock10")
	   	public String Eng_mock10() {
	   		return "mock/Eng.html/Eng_mock10";
	   	}
	   	
	   	
	   	@GetMapping("/gk_mock1")
	   	public String gk_mock1() {
	   		return "mock/GK/gk_mock1";
	   	}
	    @GetMapping("/gk_mock2")
	   	public String gk_mock2() {
	   		return "mock/GK/gk_mock2";
	   	}
	    @GetMapping("/gk_mock3")
	   	public String gk_mock3() {
	   		return "mock/GK/gk_mock3";
	   	}
	    @GetMapping("/gk_mock4")
	   	public String gk_mock4() {
	   		return "mock/GK/gk_mock4";
	   	}
	    @GetMapping("/gk_mock5")
	   	public String gk_mock5() {
	   		return "mock/GK/gk_mock5";
	   	}
	   	@GetMapping("/gk_mock6")
	   	public String gk_mock6() {
	   		return "mock/GK/gk_mock6";
	   	}
	   	@GetMapping("/gk_mock7")
	   	public String gk_mock7() {
	   		return "mock/GK/gk_mock7";
	   	}
	   	@GetMapping("/gk_mock8")
	   	public String gk_mock8() {
	   		return "mock/GK/gk_mock8";
	   	}
	   	@GetMapping("/gk_mock9")
	   	public String gk_mock9() {
	   		return "mock/GK/gk_mock9";
	   	}
	   	@GetMapping("/gk_mock10")
	   	public String gk_mock10() {
	   		return "mock/GK/gk_mock10";
	   	}
	   	
	   	@GetMapping("/Math_mock1")
	   	public String Math_mock1() {
	   		return "mock/maths/Math_mock1";
	   	}
	    @GetMapping("/Math_mock2")
	   	public String Math_mock2() {
	   		return "mock/maths/Math_mock2";
	   	}
	    @GetMapping("/Math_mock3")
	   	public String Math_mock3() {
	   		return "mock/maths/Math_mock3";
	   	}
	    @GetMapping("/Math_mock4")
	   	public String Math_mock4() {
	   		return "mock/maths/Math_mock4";
	   	}
	    @GetMapping("/Math_mock5")
	   	public String Math_mock5() {
	   		return "mock/maths/Math_mock5";
	   	}
	   	@GetMapping("/Math_mock6")
	   	public String Math_mock6() {
	   		return "mock/maths/Math_mock6";
	   	}
	   	@GetMapping("/Math_mock7")
	   	public String Math_mock7() {
	   		return "mock/maths/Math_mock7";
	   	}
	   	@GetMapping("/Math_mock8")
	   	public String Math_mock8() {
	   		return "mock/maths/Math_mock8";
	   	}
	   	@GetMapping("/Math_mock9")
	   	public String Math_mock9() {
	   		return "mock/maths/Math_mock9";
	   	}
	   	@GetMapping("/Math_mock10")
	   	public String Math_mock10() {
	   		return "mock/maths/Math_mock10";
	   	}
	 	@GetMapping("/Reasioning_mock1")
	   	public String Reasioning_mock1() {
	   		return "mock/reasoning/Reasioning_mock1";
	   	}
	    @GetMapping("/Reasioning_mock2")
	   	public String Reasioning_mock2() {
	   		return "mock/reasoning/Reasioning_mock2";
	   	}
	    @GetMapping("/Reasioning_mock3")
	   	public String Reasioning_mock3() {
	   		return "mock/reasoning/Reasioning_mock3";
	   	}
	    @GetMapping("/Reasioning_mock4")
	   	public String Reasioning_mock4() {
	   		return "mock/reasoning/Reasioning_mock4";
	   	}
	    @GetMapping("/Reasioning_mock5")
	   	public String Reasioning_mock5() {
	   		return "mock/reasoning/Reasioning_mock5";
	   	}
	   	@GetMapping("/Reasioning_mock6")
	   	public String Reasioning_mock6() {
	   		return "mock/reasoning/Reasioning_mock6";
	   	}
	   	@GetMapping("/Reasioning_mock7")
	   	public String Reasioning_mock7() {
	   		return "mock/reasoning/Reasioning_mock7";
	   	}
	   	@GetMapping("/Reasioning_mock8")
	   	public String Reasioning_mock8() {
	   		return "mock/reasoning/Reasioning_mock8";
	   	}
	   	@GetMapping("/Reasioning_mock9")
	   	public String Reasioning_mock9() {
	   		return "mock/reasoning/Reasioning_mock9";
	   	}
	   	@GetMapping("/Reasioning_mock10")
	   	public String Reasioning_mock10() {
	   		return "mock/reasoning/Reasioning_mock10";
	   	}
	   	
	   	
	   	@GetMapping("/html")
	   	public String html() {
	   		return "course_content";
	   	}
	   	@GetMapping("/download")
	   	public String download() {
	   		return "certi";
	   	}
	   	
	}
	