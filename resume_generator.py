class A:
    def __init__(self, name, age, skills):
        self.name = name
        self.age = age
        self.skills = skills

    def check(self):
        print(f"Name: {self.name}")

A_instance = A("Alice", 30, ["Python", "JavaScript", "SQl"])
A_instance.check()
