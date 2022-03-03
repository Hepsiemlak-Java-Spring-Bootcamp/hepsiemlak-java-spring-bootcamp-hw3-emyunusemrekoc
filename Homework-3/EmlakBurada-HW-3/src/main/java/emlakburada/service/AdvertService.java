package main.java.emlakburada.service;

import java.util.ArrayList;
import java.util.List;

import emlakburada.client.request.AddressRequest;
import emlakburada.client.request.BannerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emlakburada.client.BannerClient;
import emlakburada.dto.AdvertRequest;
import emlakburada.dto.response.AdvertResponse;
import emlakburada.model.Advert;
import emlakburada.model.RealEstate;
import emlakburada.model.User;
import emlakburada.queue.QueueService;
import emlakburada.repository.AdvertRepository;

@Service
public class AdvertService {

	@Autowired
	private AdvertRepository advertRepository;

	private static int advertNo = 38164784;

	@Autowired
	private BannerClient bannerClient;

//	@Autowired
//	private QueueService rabbitMqService;

	@Autowired
	private QueueService activeMqService;


	// @Autowired
//	public IlanService(IlanRepository ilanRepository) {
//		super();
//		this.ilanRepository = ilanRepository;
//	}

	public List<AdvertResponse> getAllAdverts() {
		// System.out.println("IlanService -> ilanRepository: " +
		// advertRepository.toString());
		// kullaniciService.getAllKullanici();
		List<AdvertResponse> advertList = new ArrayList<>();
		for (Advert advert : advertRepository.fetchAllAdverts()) {
			advertList.add(convertToAdvertResponse(advert));
		}
		return advertList;
	}

	public AdvertResponse saveAdvert(AdvertRequest request) {
		Advert savedAdvert = advertRepository.saveAdvert(convertToAdvert(request));
		EmailMessage emailMessage = new EmailMessage("emyunusemrekoc@gmail.com");
		BannerRequest bannerRequest = new BannerRequest();
		bannerRequest.setAdvertNo(0);
		bannerRequest.setPhone("555");
		bannerRequest.setTotal(1);
		bannerRequest.setAddress(new AddressRequest("istanbul", "kadıköy", "acik adres"));
		//rabbitMqService.sendMessage(emailMessage);
		activeMqService.sendMessage(emailMessage);
		bannerClient.saveBanner(bannerRequest);
		return convertToAdvertResponse(savedAdvert);
	}

	private AdvertResponse convertToAdvertResponse(Advert savedAdvert) {
		AdvertResponse response = new AdvertResponse();
		response.setBaslik(savedAdvert.getBaslik());
		response.setFiyat(savedAdvert.getFiyat());
		response.setAdvertNo(savedAdvert.getAdvertNo());
		response.setUserId(savedAdvert.getUserId());
		return response;
	}

	private Advert convertToAdvert(AdvertRequest request) {
		Advert advert = new Advert(new RealEstate(), new User(), new String[5]);
		advertNo++;

		advert.setUserId(request.getUserId());
		advert.setAdvertNo(advertNo);
		advert.setBaslik(request.getBaslik());
		advert.setFiyat(request.getFiyat());
		return advert;
	}

	public AdvertResponse getAdvertByAdvertId(int advertId) {
		Advert advert = advertRepository.findAdvertByAdvertId(advertId);
		return convertToAdvertResponse(advert);
	}

	public List<AdvertResponse> findFavoriteAdvertsByUserId(int userId) {

		List<AdvertResponse> advertList = new ArrayList<>();

		for (Advert advert : advertRepository.findFavoriteAdvertsByUserId(userId)) {
			advertList.add(convertToAdvertResponse(advert));
		}

		return advertList;
	}
	

}
