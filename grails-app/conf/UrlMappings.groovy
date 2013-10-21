class UrlMappings {

	static mappings = {

		"/cars/brands" (controller: "cars", action: "brands")
		"/cars/brands/$id/models" (controller: "cars", action: "models")
		
		"/$controller/$action?/$id?(.${format})?"{
			constraints {
				// apply constraints here
			}
		}
        "/"(view:"/index")
        "500"(view:'/error')
	}
}
