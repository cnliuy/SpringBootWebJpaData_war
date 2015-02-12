package sample.jpa.repository;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sample.jpa.SampleJpaApplication;
import sample.jpa.domain.Tag;

import static org.junit.Assert.assertEquals;

/**
 * Integration tests for {@link JpaTagRepository}.
 *
 * @author Andy Wilkinson
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SampleJpaApplication.class)
public class JpaTagRepositoryIntegrationTests {

	@Autowired
	JpaTagRepository repository;

	@Test
	public void findsAllTags() {
		List<Tag> tags = this.repository.findAll();
		assertEquals(3, tags.size());
	}

}
