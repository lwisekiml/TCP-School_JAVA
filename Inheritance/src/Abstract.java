/*
	# �߻� �޼ҵ�(abstract method)?
	�ڽ� Ŭ�������� �ݵ�� �������̵� �ؾ߸� ����� �� �ִ� �޼ҵ�
	
	����ϴ� ����?
	�ڽ� Ŭ������ �ݵ�� �߻� �޼ҵ带 �����ϵ��� �ϱ� ����
	
	1)���ó�� �ߺ��Ǵ� �κ��̳� 2)�������� �κ��� �̸� �� ������� ���� ����ϰ�
	�̸� �޾� ����ϴ� �ʿ����� �ڽſ��� �ʿ��� �κи��� �������Ͽ� ��� -> ���꼺�� ���, ���� ���� ������
	
	�߻� �޼ҵ�� ����θ��� ����, ������ �ۼ�X
	�����θ� �ڽ� Ŭ�������� �������̵��Ͽ� ���
	
	����
	abstract ��ȯŸ�� �޼ҵ��̸�();
	
	
	# �߻� Ŭ����(abstract class)?
	�ϳ� �̻��� �߻� �޼ҵ带 �����ϴ� Ŭ����
	
	�߻� Ŭ������ (��ü ���� ���α׷��ֿ��� �߿��� Ư¡��) �������� ������ �޼ҵ��� ������ ������ �� �ֵ��� ����
	�ݵ�� ���Ǿ�� �ϴ� �޼ҵ带 �߻� Ŭ������ �߻� �޼ҵ�� ������ ������, �� Ŭ������ ��ӹ޴� ��� Ŭ���������� �� �߻� �޼ҵ带 �ݵ�� �������ؾ� ��
	
	����
	abstract class Ŭ�����̸� {
	    ...
	    abstract ��ȯŸ�� �޼ҵ��̸�();
	    ...
	}


	�߻� Ŭ������ ������ ���ǵǾ� ���� ���� �߻� �޼ҵ带 �����ϰ� �����Ƿ�, �ν��Ͻ��� ����X
	����� ���� �ڽ� Ŭ������ ����� �߻� Ŭ������ ��� �߻� �޼ҵ带 �������̵��� �ؾ� �ڽ� Ŭ������ �ν��Ͻ��� ���� ����
	
	�߻� Ŭ������ �߻� �޼ҵ带 �����ϰ� �ִٴ� ���� �����ϸ�, �Ϲ� Ŭ������ ��� ���� �����ϴ�.
	��, �����ڿ� �ʵ�, �Ϲ� �޼ҵ嵵 ������ �� �ֽ��ϴ�.
*/ 

abstract class Animal { abstract void cry(); }

class Cat extends Animal { void cry() { System.out.println("�Ŀ˳Ŀ�!"); } }

class Dog extends Animal { void cry() { System.out.println("�۸�!"); } }

public class Abstract {
    public static void main(String[] args) {
        // Animal a = new Animal(); // �߻� Ŭ������ �ν��Ͻ��� ������ �� ����.
        Cat c = new Cat();
        Dog d = new Dog();
 
        c.cry();
        d.cry();
    }
}