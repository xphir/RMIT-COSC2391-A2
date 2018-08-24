package cms.model.interfaces;

import cms.model.service.ServiceException;

//SADI Tutelab 2 Solution by Caspar
public interface ServiceHistory
{
	public abstract double getServiceInterval();

	public abstract double getLastService();

	public abstract double calculateWearAndTear(Job job) throws ServiceException;

	public abstract void service();
}