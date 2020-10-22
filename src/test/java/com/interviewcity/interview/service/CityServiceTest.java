package com.interviewcity.interview.service;

import com.interviewcity.interview.model.City;
import com.interviewcity.interview.repository.CityRepository;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static com.interviewcity.interview.prototype.CityPrototype.cityList;
import static com.interviewcity.interview.prototype.CityPrototype.citySP1;
import static org.mockito.ArgumentMatchers.*;

@RunWith( MockitoJUnitRunner.class )
@ContextConfiguration
public class CityServiceTest {
    @Rule
    public TestName name = new TestName();

    @InjectMocks
    private CityService cityService = new CityServiceImpl();

    @Mock
    CityRepository cityRepository;

    @Test
    public void saveCity() {
        Mockito.when(cityRepository.save(any(City.class))).thenReturn(citySP1());
        City result = cityService.save(citySP1());
        Assert.assertEquals(citySP1().getName(), result.getName());
    }
}
