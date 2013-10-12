class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.${format})?"{
            constraints {
                // apply constraints here
            }
        }

		"/carBrands"(resources:'carBrand') {
			"/models"(resources:"carModel")		
		}
        "/"(view:"/index")
        "500"(view:'/error')
	}
}
