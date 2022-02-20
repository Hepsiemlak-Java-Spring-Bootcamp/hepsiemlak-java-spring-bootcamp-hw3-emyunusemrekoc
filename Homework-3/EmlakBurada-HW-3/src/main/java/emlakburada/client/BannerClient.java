package main.java.emlakburada.client;

import emlakburada.client.request.BannerRequest;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.PostMapping;


@FeignClient(value = "feign",url ="http://localhost:8081" )
public interface BannerClient {

	@PostMapping(value = "/banners")
	void saveBanner(BannerRequest bannerRequest);

//	private BannerRequest prepareSaveBannerRequest() {
//		BannerRequest request = new BannerRequest();
//		request.setAdvertNo(0);
//		request.setPhone("555");
//		request.setTotal(1);
//		request.setAddress(new AddressRequest("istanbul", "kadıköy", "acik adres"));
//		return request;
//	}

}
