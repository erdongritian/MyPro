package com.htxa.ch.les3;

public class UserServiceProxy implements UserService {
	private String sessionId;
	@Override
	public User logon(int id, String password) throws IdPassException {
		// 连接服务器 发送请求读取响应

		// 封装请求数据
		Request request = new Request("logon", new Class[] { int.class,
				String.class }, new Object[] { id, password });

		Response response = SocketUtil.remoteCall(request);
		//判断服务器调用业务是否有异常
		if(!response.isSuccess())throw new RuntimeException(response.getException().getMessage());
		//得到服务器业务的返回值
		User user = (User)response.getObj();
		this.sessionId = response.getSessionId();
		return user;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		Request request = new Request();
		request.setSessionId(sessionId);//登录之后以后发送请求一定要包含sessionId
		//包装其它数据   和服务器进行交互

	}
}
